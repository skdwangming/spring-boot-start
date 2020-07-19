package com.wm.spring.boot.dao;

import com.wm.spring.boot.entity.PurchaseRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseRecord record);

    int insertSelective(PurchaseRecord record);

    PurchaseRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PurchaseRecord record);

    int updateByPrimaryKey(PurchaseRecord record);
}