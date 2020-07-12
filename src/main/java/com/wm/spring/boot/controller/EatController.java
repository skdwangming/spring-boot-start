package com.wm.spring.boot.controller;

import com.wm.spring.boot.dao.EatDateMapper;
import com.wm.spring.boot.entity.EatDate;
import com.wm.spring.boot.entity.Restaurant;
import com.wm.spring.boot.service.RestaurantService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname Eat
 * @Description TODO
 * @Date 2020/7/11 14:57.
 * @Author wm
 */
@RestController
public class EatController {

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
