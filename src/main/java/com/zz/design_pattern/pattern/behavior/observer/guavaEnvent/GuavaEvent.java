package com.zz.design_pattern.pattern.behavior.observer.guavaEnvent;
import com.google.common.eventbus.Subscribe;

public class GuavaEvent {

    @Subscribe
    public void subscribe(String s){
        System.out.println("执行subscribe方法，参数是: " + s);
    }

}
