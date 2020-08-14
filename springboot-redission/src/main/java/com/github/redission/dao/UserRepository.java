package com.github.redission.dao;

import com.github.redission.entity.User;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {
    @Autowired
    private RedissonClient redissonClient;
    
    /**
     *  RedissonClient操作实例可参考
     *  https://github.com/redisson/redisson/wiki/6.-%E5%88%86%E5%B8%83%E5%BC%8F%E5%AF%B9%E8%B1%A1
     * @param userId
     * @return
     */
    public User getUser(String userId) {
        RMap<String, User> map = redissonClient.getMap("myMap");
        boolean contains = map.containsKey(userId);
        if (contains) {
            User user = map.get(userId);
            return user;
        }
        return null;
    }

    public String setUser(User user) {
        RMap<String, User> map = redissonClient.getMap("myMap");
        map.put(user.getId(),user);
        return user.getId();
    }
}
