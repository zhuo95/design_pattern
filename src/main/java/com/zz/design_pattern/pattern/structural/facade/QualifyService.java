package com.zz.design_pattern.pattern.structural.facade;

//积分校验
public class QualifyService {
    public boolean isAvailable(PointsGift pointsGift){
        System.out.println("校验"+ pointsGift.getName()+ "积分通过，库存通过");
        return true;
    }
}
