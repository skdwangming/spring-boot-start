package com.wm.spring.boot.service.impl;

import com.wm.spring.boot.dao.EatDateMapper;
import com.wm.spring.boot.dao.RestaurantMapper;
import com.wm.spring.boot.entity.EatDate;
import com.wm.spring.boot.entity.Restaurant;
import com.wm.spring.boot.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.logging.Logger;

/**
 * @Classname RestaurantServcieImpl
 * @Description TODO
 * @Date 2020/7/11 16:43
 * @Author wm
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantMapper restaurantMapper;

    @Override
    public Restaurant getOne() {
        Restaurant restaurant = null;
        try {
            restaurant = restaurantMapper.selectByPrimaryKey(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restaurant;
    }
}
