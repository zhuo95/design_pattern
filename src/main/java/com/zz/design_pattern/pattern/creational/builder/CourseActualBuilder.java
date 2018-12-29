package com.zz.design_pattern.pattern.creational.builder;

public class CourseActualBuilder extends CourseBuilder {

    private Course course = new Course();

    @Override
    public void buildName(String courseName) {
        course.setName(courseName);
    }

    @Override
    public void buildPPT(String coursePPT) {
        course.setPPT(coursePPT);
    }

    @Override
    public void buildVideo(String courseVideo) {
        course.setVideo(courseVideo);
    }

    @Override
    public void buildNote(String courseNote) {
        course.setNote(courseNote);
    }

    @Override
    public void buildQA(String courseQA) {
        course.setQA(courseQA);
    }

    @Override
    public Course makeCourse() {
        return course;
    }
}
