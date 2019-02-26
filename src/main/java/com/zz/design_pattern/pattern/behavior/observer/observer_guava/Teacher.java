package com.zz.design_pattern.pattern.behavior.observer.observer_guava;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.Observable;
import java.util.Observer;

//讲师订阅观察课程，问题属于课程
public class Teacher {
    private String teacherName;

    public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }

    @Subscribe
    public void getQuestion(Question q){
        System.out.println(q.getUserName() + "的问题: " + q.getQuestion());
    }



}
