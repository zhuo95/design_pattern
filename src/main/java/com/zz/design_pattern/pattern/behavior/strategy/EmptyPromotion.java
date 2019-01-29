package com.zz.design_pattern.pattern.behavior.strategy;

public class EmptyPromotion implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("empty");
    }
}
