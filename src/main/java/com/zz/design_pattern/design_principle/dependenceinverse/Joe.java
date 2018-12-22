package com.zz.design_pattern.design_principle.dependenceinverse;

public class Joe {
    ICourse iCourse;

    public Joe(ICourse iCourse){
        this.iCourse = iCourse;
    }

//    public void studyJava(){
//        System.out.println("Joe is studying java");
//    }
//
//    public void studyPython(){
//        System.out.println("Joe is studying python");
//    }

    public void studyCourse(){
        iCourse.studyCourse();
    }

    public void setiCourse(ICourse iCourse) {
        this.iCourse = iCourse;
    }
}
