package com.zz.design_pattern.pattern.creational.factorymethod;


/**
 *
 * 工厂方法
 */
public class Test {
    public static void main(String[] args) {
        VideoFactory videoFactory = new JavaVideoFactory();
        Video video = videoFactory.getVideo();
        video.produce();
    }
}
