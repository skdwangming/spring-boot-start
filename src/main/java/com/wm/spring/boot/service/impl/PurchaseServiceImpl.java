package com.wm.spring.boot.service.impl;

import com.wm.spring.boot.dao.ProductMapper;
import com.wm.spring.boot.dao.PurchaseRecordMapper;
import com.wm.spring.boot.entity.Product;
import com.wm.spring.boot.entity.PurchaseRecord;
import com.wm.spring.boot.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @Classname PurchaseServiceImpl
 * @Description TODO
 * @Date 2020/7/18 21:46
 * @Author wm
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    PurchaseRecordMapper purchaseRecordMapper;

    @Override
    @Transactional
    public boolean purchase(PurchaseRecord purchaseRecord) {
        Integer userId = purchaseRecord.getUserId();
        Integer productId = purchaseRecord.getProductId();
        Integer quantity = purchaseRecord.getQuantity();
        if (userId == null || productId == null || quantity == null) {
            return false;
        }
        Product product = productMapper.selectByPrimaryKey(productId);
        //比较库容
        if (product.getStock()< quantity){
            return false;
        }
        productMapper.updateStock(productId,quantity);
        //新增购买信息
        purchaseRecord.setPrice(product.getPrice());
        double sum = product.getPrice().doubleValue() * quantity.doubleValue();
        purchaseRecord.setSum(BigDecimal.valueOf(sum));
        purchaseRecordMapper.insertSelective(purchaseRecord);
        return true;
    }

    @Override
    public boolean purchaseLock1(PurchaseRecord purchaseRecord) {
        Integer userId = purchaseRecord.getUserId();
        Integer productId = purchaseRecord.getProductId();
        Integer quantity = purchaseRecord.getQuantity();
        if (userId == null || productId == null || quantity == null) {
            return false;
        }
        //添加悲观锁
        Product product = productMapper.selectByPrimaryKeyLock1(productId);
        //比较库容
        if (product.getStock()< quantity){
            return false;
        }
        productMapper.updateStock(productId,quantity);
        //新增购买信息
        purchaseRecord.setPrice(product.getPrice());
        double sum = product.getPrice().doubleValue() * quantity.doubleValue();
        purchaseRecord.setSum(BigDecimal.valueOf(sum));
        purchaseRecordMapper.insertSelective(purchaseRecord);
        return true;
    }

    @Override
    public boolean purchaseLock2(PurchaseRecord purchaseRecord) {
        Integer userId = purchaseRecord.getUserId();
        Integer productId = purchaseRecord.getProductId();
        Integer quantity = purchaseRecord.getQuantity();
        if (userId == null || productId == null || quantity == null) {
            return false;
        }
        long start = System.currentTimeMillis();
        while (true){
            long end = System.currentTimeMillis();
            //时间超过100ms就返回false
            if (end-start>100){
                return false;
            }
            Product product = productMapper.selectByPrimaryKey(productId);
            //比较库容
            if (product.getStock()< quantity){
                return false;
            }
            int result = productMapper.updateStockLock2(productId, quantity, product.getVersion());
            //库容更改成功
            if (result==0){
                continue;
            }
            //新增购买信息
            purchaseRecord.setPrice(product.getPrice());
            double sum = product.getPrice().doubleValue() * quantity.doubleValue();
            purchaseRecord.setSum(BigDecimal.valueOf(sum));
            purchaseRecordMapper.insertSelective(purchaseRecord);
            return true;
        }
    }

}
