package com.zz.design_pattern.pattern.structural.adapter.calssAdapter;

public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("concrete target目标方法");
    }
}
