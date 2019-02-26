package com.zz.design_pattern.pattern.behavior.observer;

public class Test {

    public static void main(String[] args) {
        Course course = new Course("java Course");
        Teacher teacher = new Teacher("zz");
        course.addObserver(teacher);
        Question q = new Question();
        q.setUserName("yl");
        q.setQuestion("sb");
        course.produceQuestion(course, q);
    }
}
