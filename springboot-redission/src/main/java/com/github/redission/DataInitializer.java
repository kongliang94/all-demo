package com.github.redission;


import com.github.redission.entity.User;
import org.redisson.api.RList;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;


/**
 * 初始化数据类
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private RedissonClient redissonClient;

    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

  public DataInitializer(RedissonClient redissonClient, StringRedisTemplate stringRedisTemplate) {
        this.redissonClient = redissonClient;
        this.stringRedisTemplate = stringRedisTemplate;
    }


    @Override
    public void run(String[] args) {
        for (int i = 0; i < 3; i++) {
            // 框架封装
            stringRedisTemplate.opsForValue().set("k"+i,"v"+i);
        }

        // 自定义
        User user = new User("11", "kkk", 100L);
        redisTemplate.opsForValue().set("user1",user);

        // redisson方式
        // Redisson 在 java.util 中常用接口的基础上，为我们提供了一系列具有分布式特性的工具类
        // 如RList/RMap等
        RList<User> myList = redissonClient.getList("myList");
        RMap<String, User> map = redissonClient.getMap("myMap");
        for (int i = 0; i < 3; i++) {
            User userTemp = new User("1"+i, "k"+i, 100L);
            myList.add(userTemp);
            map.put("u1",userTemp);
        }

    }

}
