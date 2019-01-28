package com.zz.design_pattern.pattern.behavior.templatemethod;

/**
 * 模拟 课程创建过程
 */
public abstract class ACourse {

    protected final void makeCourse(){
        this.makePPT();
        this.makeVideo();
        if(needWriteNotes()){ // 钩子方法
            this.writeNotes();
        }
        this.packageCourse();
    }

    //行为固定不便，不需要重写
    final void makePPT(){
        System.out.println("制作PPT");
    }

    final void makeVideo(){
        System.out.println("制作视频");
    }

    //这是一个可选择项目，但是不可变
    final void writeNotes(){
        System.out.println("编写笔记");
    }
    //钩子方法
    protected boolean needWriteNotes(){
        return false;
    }
    //交给子类实现，每个课程都是不一样的
    abstract void packageCourse();




}
