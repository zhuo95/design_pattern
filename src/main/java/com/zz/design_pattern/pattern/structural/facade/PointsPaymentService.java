package com.zz.design_pattern.pattern.structural.facade;

//积分兑换
public class PointsPaymentService {
    public boolean pay(PointsGift pointsGift){
        //扣减积分
        System.out.println("支付"+ pointsGift.getName() + "成功");
        return true;
    }
}
