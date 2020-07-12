package com.wm.spring.boot.service;

import com.wm.spring.boot.entity.Restaurant;

/**
 * @Classname EatService
 * @Description TODO
 * @Date 2020/7/11 16:33
 * @Author wm
 */
public interface RestaurantService {

    /**
     * 随机获取一个饭馆
     * @return
     */
    public Restaurant getOne();

}
