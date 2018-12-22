package com.zz.design_pattern.pattern.creational.factorymethod;


/**
 * 工厂方法模式
 * 生产video，是同一个产品等级（java和python是同一个等级）
 * 子类来生产产品
 */
public abstract class VideoFactory {
    public abstract Video getVideo();
}
