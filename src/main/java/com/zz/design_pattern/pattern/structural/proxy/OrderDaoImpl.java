package com.zz.design_pattern.pattern.structural.proxy;

public class OrderDaoImpl implements IOrderDao {
    @Override
    public int insert(Order order) {
        System.out.println("Dao 添加成功");
        return 1;
    }
}
