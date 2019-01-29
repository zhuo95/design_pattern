package com.zz.design_pattern.pattern.behavior.strategy;

public class FanXianPromotion implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("\n返回现金促销");
    }
}
