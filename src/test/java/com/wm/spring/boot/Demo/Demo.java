package com.wm.spring.boot.Demo;

import com.wm.spring.boot.entity.User;
import org.junit.jupiter.api.Test;

public class Demo {
    @Test
    public void test1(){
        User.Builder builder = new User.Builder();
        User user = builder.setId((long) 1).setNote("wm").setUsername("wm").builder();
        System.out.println(user.toString());

    }
}
