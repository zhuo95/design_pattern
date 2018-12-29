package com.zz.design_pattern.pattern.creational.builder;

public abstract class CourseBuilder {
//    private String name;
//    private String PPT;
//    private String video;
//    private String note;
//    private String QA;

    public abstract void buildName(String courseName);
    public abstract void buildPPT(String coursePPT);
    public abstract void buildVideo(String courseVideo);
    public abstract void buildNote(String courseNote);
    public abstract void buildQA(String courseQA);

    public abstract Course makeCourse();

}
