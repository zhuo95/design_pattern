package com.zz.design_pattern.pattern.structural.proxy.staticProxy;

import com.zz.design_pattern.pattern.structural.proxy.IOrderService;
import com.zz.design_pattern.pattern.structural.proxy.Order;
import com.zz.design_pattern.pattern.structural.proxy.OrderServiceImpl;
import com.zz.design_pattern.pattern.structural.proxy.db.DataSourceContextHolder;

public class OrderServiceStaticProxy {
    private IOrderService iOrderService;

    public int saveOrder(Order order){
        beforeMethod(order);
        iOrderService = new OrderServiceImpl();
        int res = iOrderService.saveOrder(order);
        afterMethod();
        return res;
    }

    //数据库分库
    private void beforeMethod(Order order){
        int userid = order.getUserId();
        int dbRouter = userid%2;
        System.out.println("静态代理分配到 【db "+dbRouter +"】处理数据");
        //todo 设置datasource 用于分库
        DataSourceContextHolder.setDBType(String.valueOf(dbRouter));
        System.out.println("before called");
    }

    private void afterMethod(){
        System.out.println("after called");
    }
}
