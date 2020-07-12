package com.wm.spring.boot.service.impl;

import com.wm.spring.boot.entity.Restaurant;
import com.wm.spring.boot.service.RestaurantService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Classname RestaurantServiceImpl2
 * @Description TODO
 * @Date 2020/7/12 11:21
 * @Author wm
 */
@Service
public class RestaurantServiceImpl2 implements RestaurantService {
    @Override
    public Restaurant getOne() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("2");
        return restaurant;
    }
}
