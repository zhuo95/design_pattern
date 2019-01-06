package com.zz.design_pattern.pattern.structural.decorator.v2;

public abstract class AbstractDecorator extends ACake {
    private ACake aCake;

    public AbstractDecorator(ACake aCake) {
        this.aCake = aCake;
    }

    @Override
    protected String getName() {
        return this.aCake.getName();
    }

    @Override
    protected int cost() {
        return this.aCake.cost();
    }

    protected abstract void dosomething();
}
