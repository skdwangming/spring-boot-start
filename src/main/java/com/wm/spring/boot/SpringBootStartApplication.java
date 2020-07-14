package com.wm.spring.boot;

import com.wm.spring.boot.service.MyAspect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@MapperScan("com.wm.spring.boot.dao")
@SpringBootApplication(scanBasePackages = {"com.wm.spring.boot"})
public class SpringBootStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStartApplication.class, args);

    }

    // 定义切面
    @Bean(name = "myAspect")
    public MyAspect initMyAspect() {
        return new MyAspect();
    }

}
