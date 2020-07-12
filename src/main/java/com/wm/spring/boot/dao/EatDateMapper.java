package com.wm.spring.boot.dao;

import com.wm.spring.boot.entity.EatDate;
import org.springframework.stereotype.Repository;

@Repository
public interface EatDateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EatDate record);

    int insertSelective(EatDate record);

    EatDate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EatDate record);

    int updateByPrimaryKey(EatDate record);
}