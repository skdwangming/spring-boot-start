package com.wm.spring.boot.aspect;


import com.wm.spring.boot.entity.User;
import com.wm.spring.boot.validator.UserValidator;
import com.wm.spring.boot.validator.impl.UserValidatorImpl;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @DeclareParents(value = "com.wm.spring.boot.service.impl.UserServiceImpl", defaultImpl = UserValidatorImpl.class)
    public UserValidator userValidator;

    @Pointcut("execution(* com.wm.spring.boot.service.impl.*.printUser(..)) && bean(userServiceImpl)")
    public void pointCut() {
    }

    @Before("pointCut() && args(user)")
    public void beforeParam(User user) {
        System.out.println("before ......");
    }


    @After("pointCut()")
    public void after() {
        System.out.println("after ......");
    }


    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("afterReturning ......");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("afterThrowing ......");
    }


    @Around("pointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("around before......");
        jp.proceed();
        System.out.println("around after......");
    }
}
