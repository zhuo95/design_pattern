package com.zz.design_pattern.pattern.structural.decorator.v2;

public class EggDecorator extends AbstractDecorator{
    public EggDecorator(ACake aCake) {
        super(aCake);
    }

    @Override
    protected void dosomething() {

    }

    @Override
    protected String getName() {
        return super.getName()+"加鸡蛋";
    }

    @Override
    protected int cost() {
        return super.cost() +1;
    }
}
