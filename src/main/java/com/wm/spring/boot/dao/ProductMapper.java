package com.wm.spring.boot.dao;

import com.wm.spring.boot.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    /**
     * 悲观锁
     * @param id
     * @return
     */
    Product selectByPrimaryKeyLock1(Integer id);


    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    /**
     * 更新库容
     * @param productId
     * @param quantity
     */
    void updateStock(@Param("productId") Integer productId,@Param("quantity") Integer quantity);

    /**
     * 更新库容,添加悲观锁/排它锁
     * @param productId
     * @param quantity
     */
    int updateStockLock2(@Param("productId")Integer productId, @Param("quantity")Integer quantity,@Param("version")Integer version);

}