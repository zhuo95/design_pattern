package com.zz.design_pattern.pattern.behavior.templatemethod;

public class FrontendCourse extends ACourse {

    @Override
    protected boolean needWriteNotes() {
        return super.needWriteNotes();
    }

    @Override
    void packageCourse() {
        System.out.println("提供前端代码");
        System.out.println("提供图片等多媒体");
    }
}
