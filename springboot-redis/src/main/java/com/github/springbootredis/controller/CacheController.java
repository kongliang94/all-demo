package com.github.springbootredis.controller;

import com.github.springbootredis.entity.Book;
import com.github.springbootredis.repository.BooksRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 缓存测试
 */
@RestController
@CacheConfig(cacheNames = "book")
@RequestMapping("/book_cache")
public class CacheController {

    private static Logger logger= LoggerFactory.getLogger(CacheController.class);

    private final BooksRepository repository;

    public CacheController(BooksRepository repository) {
        this.repository = repository;
    }

    @Cacheable
    @GetMapping("/{id}")
    public Book findOne(@PathVariable Long id) {

        logger.info("打印语句则没有走缓存");
        Book book=new Book();
        book.setId(Long.valueOf(100));
        book.setName("book"+100);
        book.setAutherName("KK");

        // 模拟第一次请求会走数据库
        logger.info(" get it by database");
        return book;
    }

    /**
     * 在redis中开启key为自定义key
     * 也可以用SpEL表达式去写key，可以实现动态拼接key，key="#root.methodName+'['+#参数属性名+']'"会被拼接为方法名【参数】
     * @return
     */
    @GetMapping("")
    @Cacheable(keyGenerator = "redisKeyGenerator")
    public List<Book> findAllBook() {
        logger.info("打印语句则没有走缓存");
        List<Book> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Book book=new Book();
            book.setId(Long.valueOf(i+10));
            book.setName("boook"+i);
            book.setAutherName("KKK");
            list.add(book);
        }
        return list;
    }
}
