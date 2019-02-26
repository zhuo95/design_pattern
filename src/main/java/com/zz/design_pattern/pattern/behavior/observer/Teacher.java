package com.zz.design_pattern.pattern.behavior.observer;

import java.util.Observable;
import java.util.Observer;

//讲师订阅观察课程，问题属于课程
public class Teacher implements Observer {
    private String teacherName;

    public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public void update(Observable o, Object arg) {
        Course course = (Course) o;
        Question question = (Question) arg;
        System.out.println(course.getCourseName()+"老师的课程接收到"+question.getUserName()+"的问题: "+question.getQuestion());
    }
}
