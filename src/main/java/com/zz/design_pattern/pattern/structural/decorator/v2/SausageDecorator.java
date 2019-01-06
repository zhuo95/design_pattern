package com.zz.design_pattern.pattern.structural.decorator.v2;

public class SausageDecorator extends AbstractDecorator{
    public SausageDecorator(ACake aCake) {
        super(aCake);
    }

    @Override
    protected void dosomething() {

    }

    @Override
    protected String getName() {
        return super.getName() + "加一根香肠";
    }

    @Override
    protected int cost() {
        return super.cost() +2;
    }
}
