package com.wm.spring.boot.service;

import com.wm.spring.boot.entity.PurchaseRecord;
import org.springframework.stereotype.Service;

/**
 * @Classname PurchaseService
 * @Description TODO
 * @Date 2020/7/18 21:46
 * @Author wm
 */
public interface PurchaseService {

    /**
     * 购买
     * @return
     * @param purchaseRecord
     */
    boolean purchase(PurchaseRecord purchaseRecord);

    /**
     * 购买,添加悲观锁/排它锁
     * @return
     * @param purchaseRecord
     */
    boolean purchaseLock1(PurchaseRecord purchaseRecord);

    /**
     * 购买,添加乐观锁-时间戳限制
     * @return
     * @param purchaseRecord
     */
    boolean purchaseLock2(PurchaseRecord purchaseRecord);
}
