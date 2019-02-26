package com.zz.design_pattern.pattern.behavior.observer.guavaEnvent;

import com.google.common.eventbus.EventBus;

public class Test {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus(); //实现观察者模式
        GuavaEvent guavaEvent = new GuavaEvent();
        eventBus.register(guavaEvent);
        eventBus.post("post内容");

    }
}
