package com.wm.spring.boot.test.aop;

import org.aopalliance.intercept.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * @Classname Interceptor
 * @Description TODO
 * @Date 2020/7/13 22:04
 * @Author wm
 */
public interface Interceptor {
    public void before();

    public void after();

    public void around(Invocation invocation) throws InvocationTargetException, IllegalAccessException;

    public void afterReturning();

    public void afterThrowing();

    boolean useAround();
}
