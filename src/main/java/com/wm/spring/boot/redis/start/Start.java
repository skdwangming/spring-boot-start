package com.wm.spring.boot.redis.start;

import com.wm.spring.boot.redis.config.RedisConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Description TODO
 * @Date 2020/7/23 22:32
 * @Author wm
 */
public class Start {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(RedisConfig.class);
        RedisTemplate bean = applicationContext.getBean(RedisTemplate.class);
        bean.opsForValue().set("sex", "boy");

    }
}
