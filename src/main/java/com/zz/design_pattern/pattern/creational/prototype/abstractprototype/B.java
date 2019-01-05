package com.zz.design_pattern.pattern.creational.prototype.abstractprototype;

public class B extends A {
    // B 继承A 所以B 可以克隆
    public static void main(String[] args) throws CloneNotSupportedException {
        B b = new B();
        b.clone();
    }
}
