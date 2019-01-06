package com.zz.design_pattern.pattern.structural.decorator.v1;

//煎饼加蛋
public class CakeWithEgg extends Cake {
    @Override
    protected String getName() {
        return super.getName() + "加一个鸡蛋";
    }

    @Override
    protected int cost() {
        return super.cost()+ 1;
    }
}
