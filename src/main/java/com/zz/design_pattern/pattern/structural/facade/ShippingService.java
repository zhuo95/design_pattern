package com.zz.design_pattern.pattern.structural.facade;

public class ShippingService {
    public String shipGift(PointsGift pointsGift){
        System.out.println("进入物流系统:" + pointsGift.getName());
        String orderNum = "666";
        return orderNum;
    }
}
