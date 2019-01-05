package com.zz.design_pattern.pattern.structural.facade;

/**
 * 外观模式（facade）
 * 提供了一个统一的接口(giftexchange)，用来访问子系统中的一群接口（三个service）
 */
public class Test {

    public static void main(String[] args) {
        PointsGift pointsGift = new PointsGift("手表");
        GiftExchangeService giftExchangeService = new GiftExchangeService();

        giftExchangeService.giftExchange(pointsGift);
    }
}
