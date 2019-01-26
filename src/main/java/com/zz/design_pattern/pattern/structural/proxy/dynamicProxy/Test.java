package com.zz.design_pattern.pattern.structural.proxy.dynamicProxy;

import com.zz.design_pattern.pattern.structural.proxy.IOrderService;
import com.zz.design_pattern.pattern.structural.proxy.Order;
import com.zz.design_pattern.pattern.structural.proxy.OrderServiceImpl;

/**
 * 动态代理
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order();
        // order.setUserId(1);
        order.setUserId(2);
        IOrderService orderService =(IOrderService) new OrderServiceDynamicProxy(new OrderServiceImpl()).bind();
        orderService.saveOrder(order);
    }
}
