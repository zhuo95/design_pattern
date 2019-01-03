package com.zz.design_pattern.pattern.creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        //LazySingleton lazySingleton = LazySingleton.getInstance();
//        //多线程测试懒汉模式
//        Thread T1 = new Thread(new T());
//        Thread T2 = new Thread(new T());
//        T1.start();
//        T2.start();


        //test 反射对单例模式的破坏
        Class objectClass = HungrySingleton.class;
        Constructor constructor = objectClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton instance2 = (HungrySingleton) constructor.newInstance();
        System.out.println(instance == instance2);
        //得到了false， 获得了两个instance， 违背了单例模式
        //解决：
        Class objectClass2 = HungrySingletonAvoidReflection.class;
        Constructor constructor2 = objectClass2.getDeclaredConstructor();
        constructor2.setAccessible(true);
        HungrySingletonAvoidReflection instance3 = HungrySingletonAvoidReflection.getInstance();
        HungrySingletonAvoidReflection instance4 = (HungrySingletonAvoidReflection) constructor2.newInstance();
        System.out.println(instance3 == instance4);
    }
}
