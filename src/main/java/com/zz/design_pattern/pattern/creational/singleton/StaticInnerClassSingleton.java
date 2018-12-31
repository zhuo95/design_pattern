package com.zz.design_pattern.pattern.creational.singleton;

/**
 * 懒汉模式 线程安全方案2
 * 内部静态类
 * JVM 在类的初始化阶段 会去获取Class对象的初始化锁，类就只会初始化一次
 * 利用这一特性，在初始化的时候利用内部静态类初始化好一个instance，那就只有一个instance
 */
public class StaticInnerClassSingleton {
    private static class InnerClass{
        private static StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();

    }
    //私有构造器，防止外部构造
    private StaticInnerClassSingleton(){}

    public static StaticInnerClassSingleton getInstance(){
        return InnerClass.staticInnerClassSingleton;
    }
}
