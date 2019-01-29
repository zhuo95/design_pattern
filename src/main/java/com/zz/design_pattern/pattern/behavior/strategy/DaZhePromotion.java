package com.zz.design_pattern.pattern.behavior.strategy;

public class DaZhePromotion implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.printf("\n打折促销");
    }
}
