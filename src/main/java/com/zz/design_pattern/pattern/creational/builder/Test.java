package com.zz.design_pattern.pattern.creational.builder;

public class Test {
    public static void main(String[] args) {
        CourseBuilder courseBuilder = new CourseActualBuilder();
        Coach coach = new Coach();
        coach.setCourseBuilder(courseBuilder);

        Course course = coach.makeCourse("课程1","PPT","Note","QA","Video");

        System.out.println(course);
    }
}
