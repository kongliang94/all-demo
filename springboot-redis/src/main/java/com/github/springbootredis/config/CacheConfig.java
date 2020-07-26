package com.github.springbootredis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  redis缓存配置类，重写CacheManager和keyGenerator
 *
 *  可参考https://www.cnblogs.com/hujunzheng/p/9660681.html#autoid-6-3-0
 */
@Configuration
@EnableCaching
public class CacheConfig {
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {

        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(defaultCacheConfig(10000))
                .withInitialCacheConfigurations(initCacheConfigMap())
                .transactionAware()
                .build();

    }

    public RedisCacheConfiguration defaultCacheConfig(Integer second) {

        // 使用Jackson2JsonRedisSerialize 替换默认序列化(默认采用的是JDK序列化)
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);

        ObjectMapper om = new ObjectMapper();
        // 设置要序列化的域，以及类属性修饰符范围
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 设置序列化类不能是final的
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,
                ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        RedisCacheConfiguration redisCacheConfiguration =
                RedisCacheConfiguration.defaultCacheConfig()
                        .serializeKeysWith(
                                RedisSerializationContext
                                        .SerializationPair
                                        .fromSerializer(new StringRedisSerializer()))
                        .serializeValuesWith(
                                RedisSerializationContext
                                        .SerializationPair
                                        .fromSerializer(jackson2JsonRedisSerializer)
                        ).entryTtl(Duration.ofSeconds(second))
                        .disableCachingNullValues();

        return redisCacheConfiguration;
    }

    public Map<String, RedisCacheConfiguration> initCacheConfigMap(){

        Map<String, RedisCacheConfiguration> configurationMap=new HashMap<>();

        configurationMap.put("book",this.defaultCacheConfig(1000));
        configurationMap.put("book1",this.defaultCacheConfig(1000));
        configurationMap.put("book2",this.defaultCacheConfig(1000));
        return configurationMap;

    }

    /**
     * 默认使用keyGenerator生成：
     * 默认使用simpleKeyGennerator生成key：
     *     simpleKeyGennerator默认如果没有参数：key = new SimpleKey（）
     *     一个参数：key = 参数值
     *     多个参数：key = new SimpleKey（params）
     *
     * 此处自定义key生成器
     * @return
     */
    @Bean(name = "redisKeyGenerator")
    public KeyGenerator keyGenerator(){
        return (target, method, params) -> {

            List<Object> paramList=Arrays.asList(params);
            if (paramList.size()==0){
                return method.getName();
            }else {
                return method.getName()+"::"+ paramList.toString();
            }

        };
    }
}
