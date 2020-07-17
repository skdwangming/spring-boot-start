package com.wm.spring.boot.utils;

import org.apache.commons.collections4.map.LRUMap;

public class IdRepeat {

    private static LRUMap<String, Integer> cacheMap = new LRUMap<>(100);

    public static boolean repeatCommit(String id, Class lockClass) {

        if (cacheMap.containsKey(id)) {
            System.out.println("repeat id : " + id);
            return false;
        }
        synchronized (lockClass) {
            if (cacheMap.containsKey(id)) {
                System.out.println("repeat id : " + id);
                return false;
            }
        }
        cacheMap.put(id, 1);

        System.out.println("commit id : " + id);
        return true;


    }
}
