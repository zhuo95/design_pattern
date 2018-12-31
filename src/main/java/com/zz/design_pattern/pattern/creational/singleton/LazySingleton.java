package com.zz.design_pattern.pattern.creational.singleton;

/**
 * 懒汉模式，线程不安全
 */
public class LazySingleton {
    private static LazySingleton lazySingleton = null;
    private LazySingleton(){

    }

//    //线程不安全
//    public static LazySingleton getInstance(){
//        if(lazySingleton == null){
//            lazySingleton = new LazySingleton();
//        }
//        return lazySingleton;
//    }

    public synchronized static LazySingleton getInstance(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
