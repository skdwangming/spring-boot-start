package com.wm.spring.boot.aspect;

import org.aspectj.lang.annotation.*;

@Aspect
public class UserAspect {
    @Pointcut("execution (* com.wm.spring.boot.service.impl.UserServiceImpl.printUser(..)) && bean(userServiceImpl) && args(com.wm.spring.boot.entity.User)")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before(){
        System.out.println("before");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("after");
    }

    @AfterReturning("pointCut()")
    public void afterReturn(){
        System.out.println("after return");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("after throwing");
    }


}
