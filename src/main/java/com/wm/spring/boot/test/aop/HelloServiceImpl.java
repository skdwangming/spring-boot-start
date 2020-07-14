package com.wm.spring.boot.test.aop;

/**
 * @Classname HelloServiceImpl
 * @Description TODO
 * @Date 2020/7/13 22:02
 * @Author wm
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        if (name == null || name.trim() == "") {
            throw new RuntimeException("param is null");
        }
        System.out.println("hello " + name);
    }
}
