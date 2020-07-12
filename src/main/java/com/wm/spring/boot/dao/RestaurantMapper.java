package com.wm.spring.boot.dao;

import com.wm.spring.boot.entity.Restaurant;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Restaurant record);

    int insertSelective(Restaurant record);

    Restaurant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Restaurant record);

    int updateByPrimaryKey(Restaurant record);
}