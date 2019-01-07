package com.zz.design_pattern.pattern.structural.adapter.objectAdapter;


public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("concrete target目标方法");
    }
}
