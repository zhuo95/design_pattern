package com.zz.design_pattern.pattern.creational.singleton;


import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;


/**
 * 单例容器
 * 统一管理单例对象，但是线程不安全
 */
public class ContainerSingleton {
    private static Map<String, Object> singletonMap = new HashMap<String, Object>();

    public static void putInstance(String key, Object instance){
        if(!StringUtils.isEmpty(key) && instance != null){
            if(!singletonMap.containsKey(key)){
                singletonMap.put(key, instance);
            }
        }
    }

    public static Object getInstance(String key){
        return singletonMap.get(key);
    }
}
