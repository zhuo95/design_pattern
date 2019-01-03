package com.zz.design_pattern.pattern.creational.singleton;

/**
 * 饿汉模式
 */
public class HungrySingleton {
    private final static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton(){

    }

    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
