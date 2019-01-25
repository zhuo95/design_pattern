package com.zz.design_pattern.pattern.structural.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * 动态代理不止可以代理orderservice，可以代理多个service
 */
public class OrderServiceDynamicProxy implements InvocationHandler {
    private Object target;

    public OrderServiceDynamicProxy(Object target){
        this.target = target;
    }

    public Object bind(){
        Class clss = target.getClass();
        return Proxy.newProxyInstance(clss.getClassLoader(),clss.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
