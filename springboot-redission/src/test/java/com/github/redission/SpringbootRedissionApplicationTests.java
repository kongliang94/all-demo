package com.github.redission;

import org.junit.jupiter.api.Test;
import org.redisson.RedissonLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootRedissionApplicationTests {


	@Autowired
	RedissonClient redissonClient;
	@Test
	void contextLoads() {
		//RedissonLock redissonLock=redissonClient.
	}

}
