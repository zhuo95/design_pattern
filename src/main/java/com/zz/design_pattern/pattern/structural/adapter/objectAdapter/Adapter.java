package com.zz.design_pattern.pattern.structural.adapter.objectAdapter;

public class Adapter implements Target {
    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.adapteeRequest();
    }
}
