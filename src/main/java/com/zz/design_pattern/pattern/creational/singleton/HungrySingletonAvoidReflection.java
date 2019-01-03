package com.zz.design_pattern.pattern.creational.singleton;
;

/**
 * 饿汉模式 防止反射
 * 但是只能适用于在类加载中初始化的
 */
public class HungrySingletonAvoidReflection {
    private final static HungrySingletonAvoidReflection hungrySingleton = new HungrySingletonAvoidReflection();

    private HungrySingletonAvoidReflection(){
        if(hungrySingleton != null){
            throw new RuntimeException("单例模式禁止反射");
        }
    }

    public static HungrySingletonAvoidReflection getInstance(){
        return hungrySingleton;
    }
}
