package com.zz.design_pattern.pattern.structural.adapter.calssAdapter;

/**
 * 类适配器模式
 * Adaptee 是被适配的类
 * 通过继承来获取Adaptee 的方法
 */
public class Adapter extends Adaptee implements Target{
    @Override
    public void request() {
        super.adapteeRequest();
    }
}
