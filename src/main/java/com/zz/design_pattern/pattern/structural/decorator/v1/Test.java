package com.zz.design_pattern.pattern.structural.decorator.v1;

//未使用装饰着模式 v2为改善的装饰着模式写法
public class Test {
    public static void main(String[] args) {
        Cake cake = new Cake();
        System.out.println("普通价格:"+ cake.cost());

        Cake cake1 = new CakeWithEgg();
        System.out.println(cake1.getName()+"价格:"+ cake1.cost());

        Cake cake2 = new CakeWithEggAndSausage();
        System.out.println(cake2.getName()+"价格:"+ cake2.cost());
    }
}
