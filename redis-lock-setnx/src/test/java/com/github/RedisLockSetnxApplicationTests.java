package com.github;

import com.github.config.Mutex;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

@SpringBootTest
class RedisLockSetnxApplicationTests {

    @Test
    void contextLoads() {
        final Integer k=100;
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
               test(k);
            }).start();
        }
        System.out.println(k);
    }

    @Mutex(keyTemplate = "test:mutex:")
    Integer test(int i){
        System.out.println(i);
        i--;
        return i;
    }

}
