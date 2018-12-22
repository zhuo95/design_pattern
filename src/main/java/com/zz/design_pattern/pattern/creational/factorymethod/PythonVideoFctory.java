package com.zz.design_pattern.pattern.creational.factorymethod;

public class PythonVideoFctory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }
}
