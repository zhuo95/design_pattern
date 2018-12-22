package com.zz.design_pattern.pattern.creational.simplefactory;


/**
 * 可以看到 test（客户端）中是依赖于JavaVideo 这个类的
 * 让应用层不依赖于对应的具体实现类---->简单工厂模式
 *
 */
public class Test {
    public static void main(String[] args) {
        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideo("java");
        if (video==null) return;
        video.produce();
    }
}
