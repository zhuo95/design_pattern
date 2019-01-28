package com.zz.design_pattern.pattern.behavior.templatemethod;

public class Test {
    public static void main(String[] args) {
        System.out.println("后端java课程start-----------");
        ACourse javaCourse = new JavaCourse();
        javaCourse.makeCourse();
        System.out.println("后端java课程end-----------");

        System.out.println("前端课程start-----------");
        ACourse frontendCourse = new FrontendCourse();
        frontendCourse.makeCourse();
        System.out.println("前端课程end-----------");
    }
}
