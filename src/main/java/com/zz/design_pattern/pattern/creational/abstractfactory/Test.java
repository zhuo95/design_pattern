package com.zz.design_pattern.pattern.creational.abstractfactory;

/**
 * Video 和 Note 是抽象产品
 * JavaVideo 和 JavaNote 是具体产品, 他们属于同一个产品族
 * 抽象工厂模式的好处就是同一个产品族可以一起生产，不用关注具体分别的实现细节
 */

public class Test {

    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaCourseFactory();

        Video video = courseFactory.getVideo();

        Note note = courseFactory.getNote();

        video.produce();

        note.produce();
    }
}
