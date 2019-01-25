package com.zz.design_pattern.pattern.structural.proxy;

public class OrderServiceImpl implements IOrderService {

    private IOrderDao iOrderDao;

    @Override
    public int saveOrder(Order order) {
        //spring 会自己注入
        iOrderDao = new OrderDaoImpl();
        return iOrderDao.insert(order);
    }
}
