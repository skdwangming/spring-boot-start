package com.wm.spring.boot.service;


import com.wm.spring.boot.entity.User;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspect {
	
//	@DeclareParents(value= "com.springboot.chapter4.aspect.service.impl.UserServiceImpl+", defaultImpl=UserValidatorImpl.class)
//	public UserValidator userValidator;
	
	@Pointcut("execution(* com.wm.spring.boot.service.impl.*.printUser(..)) && bean('userServiceImpl')")
	public void pointCut() {
	}
	
	@Before("pointCut() && args(user)")
	public void beforeParam( User user) {
		System.out.println("before ......");
	} 
	
//	@Before("pointCut()")
//	public void before() {
//		System.out.println("before ......");
//	}
	
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
	

//	@Around("pointCut()")
//	public void around(ProceedingJoinPoint jp) throws Throwable {
//		System.out.println("around before......");
//		jp.proceed();
//		System.out.println("around after......");
//	}
}
