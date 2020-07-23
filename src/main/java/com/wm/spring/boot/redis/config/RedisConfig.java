package com.wm.spring.boot.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Description TODO
 * @Date 2020/7/23 22:08
 * @Author wm
 */
@Configuration
public class RedisConfig {

    public RedisConnectionFactory initFactory() {
        //实现自commons-pool2
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(50);
        config.setMaxTotal(100);
        config.setMaxWaitMillis(2000);
        JedisConnectionFactory factory = new JedisConnectionFactory(config);
        RedisStandaloneConfiguration configuration = factory.getStandaloneConfiguration();
        configuration.setHostName("127.0.0.1");
        configuration.setPort(6379);
        return factory;
    }

    @Bean
    public RedisTemplate<Object, Object> initRedisTemplate() {
        RedisConnectionFactory redisConnectionFactory = initFactory();
        //默认使用jdk序列化
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        //使用StringSerializer序列化
        RedisSerializer<String> stringSerializer = template.getStringSerializer();
        //key序列化
        template.setKeySerializer(stringSerializer);
        //value序列化
        template.setValueSerializer(stringSerializer);
        return template;
    }
}
