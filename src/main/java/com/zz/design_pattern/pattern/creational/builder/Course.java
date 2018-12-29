package com.zz.design_pattern.pattern.creational.builder;

public class Course {
    private String name;
    private String PPT;
    private String video;
    private String note;
    private String QA;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPPT() {
        return PPT;
    }

    public void setPPT(String PPT) {
        this.PPT = PPT;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getQA() {
        return QA;
    }

    public void setQA(String QA) {
        this.QA = QA;
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
