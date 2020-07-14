package com.wm.spring.boot.validator;


import com.wm.spring.boot.entity.User;

public interface UserValidator {
	
	public boolean validate(User user);
}
