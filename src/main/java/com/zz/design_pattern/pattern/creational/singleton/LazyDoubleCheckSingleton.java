package com.zz.design_pattern.pattern.creational.singleton;

/**
 * 懒汉模式 线程安全方案1
 * doublecheck 并且 阻止重排序
 */
public class LazyDoubleCheckSingleton {

    private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;
    private LazyDoubleCheckSingleton(){

    }

    //这里有个隐患 第12行，和15行
    //解决方法 volatile修饰
    //volatile作用：
    // 1.将当前处理器缓存好的数据写回内存
    // 2. 会使在其他cpu中该内存地址的数据无效，所以会重新读取
    // 阻止了重排序
    public static LazyDoubleCheckSingleton getInstance(){
        if(lazyDoubleCheckSingleton == null){
            synchronized (LazyDoubleCheckSingleton.class){
                if(lazyDoubleCheckSingleton == null){
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                    // new 的过程
                    //1.分配内存
                    //2.初始化对象
                    //3.设置 lazyDoubleCheckSingleton 指向分配的内存
                    // 2 和 3 有可能重排序，所以获取到的对象可能还没有初始化，使用就会报错
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }
}
