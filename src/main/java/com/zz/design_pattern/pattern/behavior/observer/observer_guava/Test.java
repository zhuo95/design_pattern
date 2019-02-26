package com.zz.design_pattern.pattern.behavior.observer.observer_guava;

import com.google.common.eventbus.EventBus;

public class Test {
    public static void main(String[] args) {
        Course c = new Course("java", new Teacher("zz"));
        c.postQuestion(new Question("yl","123"));
    }
}
