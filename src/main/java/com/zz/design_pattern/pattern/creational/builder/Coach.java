package com.zz.design_pattern.pattern.creational.builder;

//课程教练，来制作course
public class Coach {
    private CourseBuilder courseBuilder;

    public void setCourseBuilder(CourseBuilder courseBuilder) {
        this.courseBuilder = courseBuilder;
    }

    public Course makeCourse(String courseName, String coursePPT, String courseNote, String courseQA, String courseVideo){
        this.courseBuilder.buildName(courseName);
        this.courseBuilder.buildNote(courseNote);
        this.courseBuilder.buildPPT(coursePPT);
        this.courseBuilder.buildVideo(courseVideo);
        this.courseBuilder.buildQA(courseQA);
        return this.courseBuilder.makeCourse();
    }


}
