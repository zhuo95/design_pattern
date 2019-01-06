package com.zz.design_pattern.pattern.structural.decorator.v2;

public class Test {
    public static void main(String[] args) {
        ACake aCake = new Cake();

        aCake = new EggDecorator(aCake);

        aCake = new SausageDecorator(aCake);

        aCake = new EggDecorator(aCake);

        System.out.println(aCake.getName()+ " 价格：" + aCake.cost());
    }
}
