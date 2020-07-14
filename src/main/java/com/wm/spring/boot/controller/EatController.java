package com.wm.spring.boot.controller;

import com.wm.spring.boot.entity.Restaurant;
import com.wm.spring.boot.entity.User;
import com.wm.spring.boot.service.RestaurantService;
import com.wm.spring.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


/**
 * @Classname Eat
 * @Description TODO
 * @Date 2020/7/11 14:57.
 * @Author wm
 */
@RestController
public class EatController {

    // 注入用户服务
    @Autowired
    private UserService userService = null;

    // 定义请求
    @RequestMapping("/print")
    // 返回json
    @ResponseBody
    public User printUser(Long id, String userName, String note) {
        User user = new User();
        user.setId(id);
        user.setUsername(userName);
        user.setNote(note);
        userService.printUser(user);
        return user;
    }

    @Autowired
    @Qualifier("restaurantServiceImpl")
    private RestaurantService restaurantService;

    @GetMapping("/getOne")
    @ResponseBody
    public Restaurant getOne() {
        Restaurant one = restaurantService.getOne();
        return one;
    }


}
