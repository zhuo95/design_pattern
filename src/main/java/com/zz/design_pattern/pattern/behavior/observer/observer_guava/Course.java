package com.zz.design_pattern.pattern.behavior.observer.observer_guava;


import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class Course {
    private String courseName;
    private Teacher teacher;
    private EventBus eventBus;

    public String getCourseName() {
        return courseName;

    }

    public Course(String courseName, Teacher teacher) {
        this.courseName = courseName;
        this.teacher = teacher;
        eventBus = new EventBus();
        eventBus.register(teacher);
    }

    public void postQuestion(Question q){
        eventBus.post(q);
    }
}
