/*
package com.github.redission.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.github.redission.entity.OrderEntity;
import org.redisson.api.RedissonClient;
import org.redisson.spring.data.connection.RedissonConnection;
import org.redisson.spring.data.connection.RedissonConnectionFactory;
import org.redisson.spring.starter.RedissonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisConfig {

    @Autowired
    private RedissonClient redissonClient;


    @Bean
    @Primary
    @Qualifier
    public ReactiveRedisConnectionFactory reactiveRedisConnectionFactory() {
        //return new RedissonConnectionFactory(redissonClient);
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("81.70.15.115", 16379);
        redisStandaloneConfiguration.setPassword("qwertyui");
        return new LettuceConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean
    @Primary
    @Qualifier
    public ReactiveRedisTemplate<String, OrderEntity> orderEntityReactiveRedisTemplate(ReactiveRedisConnectionFactory reactiveRedisConnectionFactory) {
        StringRedisSerializer keySerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer<OrderEntity> valueSerializer =
                new Jackson2JsonRedisSerializer<>(OrderEntity.class);
        RedisSerializationContext.RedisSerializationContextBuilder<String, OrderEntity> builder =
                RedisSerializationContext.newSerializationContext(keySerializer);
        RedisSerializationContext<String, OrderEntity> context =
                builder.value(valueSerializer).build();
        return new ReactiveRedisTemplate<>(reactiveRedisConnectionFactory, context);
    }

}
*/
