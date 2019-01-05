package com.zz.design_pattern.pattern.structural.facade;

//积分礼物
public class PointsGift extends ShippingService {
    private String name;

    public PointsGift(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
