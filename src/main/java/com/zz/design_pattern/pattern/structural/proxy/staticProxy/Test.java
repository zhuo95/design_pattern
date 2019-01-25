package com.zz.design_pattern.pattern.structural.proxy.staticProxy;

import com.zz.design_pattern.pattern.structural.proxy.Order;

public class Test {
    public static void main(String[] args) {
        Order order = new Order();
        // order.setUserId(1);
        order.setUserId(2);
        OrderServiceStaticProxy orderServiceStaticProxy = new OrderServiceStaticProxy();
        orderServiceStaticProxy.saveOrder(order);
    }


}
