package com.github.springbootredis.repository;

import com.github.springbootredis.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 *  redis作为数据库的操作类
 */
@Repository
public class BooksRepository {

    private final String prefix="book:";
    private final RedisTemplate<String, Book> redisTemplate;

    public BooksRepository(RedisTemplate<String, Book> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void save(Book book) {
        redisTemplate.opsForValue()
                .set(prefix+book.getId(), book);
    }

    public Book findById(Long id) {
        return redisTemplate.opsForValue()
                .get(prefix+id);
    }

    public List<Book> findAll(){
        Set<String> ids=keys(prefix+"*").stream().collect(Collectors.toSet());
        return redisTemplate.opsForValue().multiGet(ids);
    }

    public void deleteAll(){
        Set<String> keys =keys("*").stream().collect(Collectors.toSet());
        redisTemplate.delete(keys);
    }


    /**
     * scan 实现
     * @param pattern   表达式
     * @param consumer  对迭代到的key进行操作
     */
    public void scan(String pattern, Consumer<byte[]> consumer) {
        this.redisTemplate.execute((RedisConnection connection) -> {
            //try catch 的语法来自动执行 Closable 接口的 close() 方法
            //match：key的正则表达式
            //count：每次扫描的记录数。值越小，扫描次数越过、越耗时。建议设置在1000-10000
            try (Cursor<byte[]> cursor = connection.scan(ScanOptions.scanOptions().count(1000).match(pattern).build())) {
                cursor.forEachRemaining(consumer);
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * 获取符合条件的key
     * @param pattern   表达式
     * @return
     */
    public List<String> keys(String pattern) {
        List<String> keys = new ArrayList<>();
        this.scan(pattern, item -> {
            //符合条件的key
            String key = new String(item, StandardCharsets.UTF_8);
            keys.add(key);
        });
        return keys;
    }
}
