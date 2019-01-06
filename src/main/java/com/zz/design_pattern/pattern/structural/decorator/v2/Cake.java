package com.zz.design_pattern.pattern.structural.decorator.v2;

public class Cake extends ACake {
    @Override
    protected String getName() {
        return "普通煎饼";
    }

    @Override
    protected int cost() {
        return 8;
    }
}
