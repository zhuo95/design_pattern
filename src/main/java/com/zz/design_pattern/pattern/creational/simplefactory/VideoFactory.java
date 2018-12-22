package com.zz.design_pattern.pattern.creational.simplefactory;


/**
 * 简单工厂的缺点是，如果要添加新的type，就要修改代码
 * 但是可以通过反射来优化
 */
public class VideoFactory {
    public Video getVideo(String type){
        if("java".equalsIgnoreCase(type)){
            return new JavaVideo();
        }else if("python".equalsIgnoreCase(type)){
            return new PythonVideo();
        }
        return null;
    }
}
