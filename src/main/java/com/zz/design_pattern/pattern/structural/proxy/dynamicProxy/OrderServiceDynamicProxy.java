package com.zz.design_pattern.pattern.structural.proxy.dynamicProxy;

import com.zz.design_pattern.pattern.structural.proxy.Order;
import com.zz.design_pattern.pattern.structural.proxy.db.DataSourceContextHolder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * 动态代理不止可以代理orderservice，可以代理多个service.
 */
public class OrderServiceDynamicProxy implements InvocationHandler {
    private Object target;

    //target 是代理的目标类
    public OrderServiceDynamicProxy(Object target){
        this.target = target;
    }


    public Object bind(){
        Class clss = target.getClass();
        return Proxy.newProxyInstance(clss.getClassLoader(),clss.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object argObject = args[0];
        beforMethod(argObject);
        Object object = method.invoke(target, args);
        afterMethod();
        return object;
    }


    public void beforMethod(Object obj) {
        int userId = 0;
        System.out.println("动态代理，before called");
        if (obj instanceof Order) {
            Order order = (Order) obj;
            int dbRouter = userId % 2;
            System.out.println("动态代理分配到 【db " + dbRouter + "】处理数据");
            //todo 设置datasource 用于分库
            DataSourceContextHolder.setDBType(String.valueOf(dbRouter));

        }
    }

    private void afterMethod(){
        System.out.println("after called");
    }

}
