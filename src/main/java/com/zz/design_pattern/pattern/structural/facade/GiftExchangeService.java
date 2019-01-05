package com.zz.design_pattern.pattern.structural.facade;

/**
 * 这个类就是facade，用于访问三个子系统（积分商品校验，兑换，物流）
 *
 */
public class GiftExchangeService {
    private QualifyService qualifyService = new QualifyService();

    private PointsPaymentService pointsPaymentService = new PointsPaymentService();

    private ShippingService shippingService = new ShippingService();


    public void giftExchange(PointsGift pointsGift){
        if (qualifyService.isAvailable(pointsGift)){
            if(pointsPaymentService.pay(pointsGift)){
                String orderNum = shippingService.shipGift(pointsGift);
                System.out.println("下单成功，物流号:"+ orderNum);
            }
        }
    }
}

