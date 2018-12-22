package com.zz.design_pattern.design_principle.dependenceinverse;

/**
 * 如果Joe还要干别的事情，还要在Joe class中修改，这样其实是面向实现编程
 * Test 是高层次模块， Joe 是低层次模块， 根据依赖倒置， 高层次模块不应该依赖于低层次
 *
 */

public class Test {
    public static void main(String[] args) {

        Joe joe = new Joe(new JavaCourse());
//v1
//        joe.studyJava();
//        joe.studyPython();
//v2
//        joe.studyCourse(new JavaCourse());

        joe.studyCourse();

        joe.setiCourse(new PythonCourse());

        joe.studyCourse();
    }
}
