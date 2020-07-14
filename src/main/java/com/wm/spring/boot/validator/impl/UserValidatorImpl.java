package com.wm.spring.boot.validator.impl;


import com.wm.spring.boot.entity.User;
import com.wm.spring.boot.validator.UserValidator;

public class UserValidatorImpl implements UserValidator {

    @Override
    public boolean validate(User user) {
        System.out.println("引入新的接口：" + UserValidator.class.getSimpleName());
        return user != null;
    }

}
