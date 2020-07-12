package com.wm.spring.boot.test;

import com.wm.spring.boot.entity.Restaurant;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @Classname IocTest
 * @Description TODO
 * @Date 2020/7/11 22:49
 * @Author wm
 */
public class IocTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Cat bean = ctx.getBean(Cat.class);
        Cat bean2 = ctx.getBean(Cat.class);
        System.out.println(bean);
        System.out.println(bean2);

    }
}
