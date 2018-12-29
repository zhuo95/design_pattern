package com.zz.design_pattern.pattern.creational.builder.v2;

/**
 * 建造者模式
 * 使用一个静态内部类作为builder
 */
public class Course {
    private String name;
    private String PPT;
    private String video;
    private String note;
    private String QA;

    public Course(CourseBuilder courseBuilder){
        this.name = courseBuilder.name;
        this.note = courseBuilder.note;
        this.PPT = courseBuilder.PPT;
        this.QA = courseBuilder.QA;
        this.video = courseBuilder.video;
    }

    public static class CourseBuilder{
        private String name;
        private String PPT;
        private String video;
        private String note;
        private String QA;

        public CourseBuilder buildNmae(String courseName){
            this.name = courseName;
            return this;
        }

        public CourseBuilder buildPPT(String coursePPT) {
            this.PPT = coursePPT;
            return this;
        }

        public CourseBuilder buildVideo(String courseVideo) {
            this.video = courseVideo;
            return this;
        }

        public CourseBuilder buildNote(String courseNote) {
            this.note = courseNote;
            return this;
        }

        public CourseBuilder buildQA(String courseQA) {
            this.QA = courseQA;
            return this;
        }

        public Course build(){
            return new Course(this);
        }

    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", PPT='" + PPT + '\'' +
                ", video='" + video + '\'' +
                ", note='" + note + '\'' +
                ", QA='" + QA + '\'' +
                '}';
    }
}
