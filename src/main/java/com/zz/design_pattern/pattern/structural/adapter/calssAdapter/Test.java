package com.zz.design_pattern.pattern.structural.adapter.calssAdapter;

public class Test {
    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();

        Target adapterTarget = new Adapter();

        adapterTarget.request();
    }
}
