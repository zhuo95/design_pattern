package com.zz.design_pattern.pattern.structural.decorator.v1;

//煎饼加蛋加香肠
public class CakeWithEggAndSausage extends CakeWithEgg {
    @Override
    protected String getName() {
        return super.getName() + "加一个香肠";
    }

    @Override
    protected int cost() {
        return super.cost() + 2;
    }
}
