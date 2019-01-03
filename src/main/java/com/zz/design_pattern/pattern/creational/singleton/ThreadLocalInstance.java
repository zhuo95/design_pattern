package com.zz.design_pattern.pattern.creational.singleton;

/**
 * threadlocal 会为每一个线程提供一个不同的instance
 * 但是同一个线程中获取的instance是一样的
 */
public class ThreadLocalInstance {
    private static final ThreadLocal<ThreadLocalInstance> threadLocalInstance
            = new ThreadLocal<ThreadLocalInstance>(){
        @Override
        protected ThreadLocalInstance initialValue() {
            return new ThreadLocalInstance();
        }
    };

    private ThreadLocalInstance(){}

    public static ThreadLocalInstance getInstance(){
        return threadLocalInstance.get();
    }
}
