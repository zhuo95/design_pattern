package com.zz.design_pattern.design_principle.singleresponsibility;

/**
 * 一个类 一个接口 就一个职责
 */
public class Test {

    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.mainMoveMode("大雁");
        bird.mainMoveMode("鸵鸟");

        FlyBird bird1 = new FlyBird();
        WalkBird bird2 = new WalkBird();
    }
}
