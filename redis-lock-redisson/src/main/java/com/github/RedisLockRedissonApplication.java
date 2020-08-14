package com.github;

import com.github.redisson.config.EnableRedissonLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableRedissonLock
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class RedisLockRedissonApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisLockRedissonApplication.class, args);
	}

}
