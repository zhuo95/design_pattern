package com.zz.design_pattern.pattern.behavior.observer;

import java.util.Observable;

public class Course extends Observable {
    private String courseName;

    public String getCourseName() {
        return courseName;
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void produceQuestion(Course course, Question question){
        System.out.println(question.getUserName() + "在" + course.getCourseName()+"提出问题: "+question.getQuestion());
        setChanged(); // observable  changed
        notifyObservers(question);
    }
}
