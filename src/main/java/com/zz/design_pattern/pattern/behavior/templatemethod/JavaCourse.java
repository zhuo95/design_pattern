package com.zz.design_pattern.pattern.behavior.templatemethod;

public class JavaCourse extends ACourse {
    @Override
    protected boolean needWriteNotes() {
        return true;
    }

    @Override
    void packageCourse() {
        System.out.println("提供java源代码");
    }
}
