package com.wm.spring.boot.test.annotation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Classname Cat
 * @Description TODO
 * @Date 2020/7/12 16:47
 * @Author wm
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Cat implements Animal {
}
