package com.zz.design_pattern.design_principle.dependenceinverse;

public class JavaCourse implements ICourse {

    @Override
    public void studyCourse() {
        System.out.println("Joe is studying java");
    }
}
