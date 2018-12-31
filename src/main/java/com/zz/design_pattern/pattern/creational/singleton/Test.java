package com.zz.design_pattern.pattern.creational.singleton;

public class Test {
    public static void main(String[] args) {
        //LazySingleton lazySingleton = LazySingleton.getInstance();
        //多线程测试懒汉模式
        Thread T1 = new Thread(new T());
        Thread T2 = new Thread(new T());
        T1.start();
        T2.start();
    }
}
