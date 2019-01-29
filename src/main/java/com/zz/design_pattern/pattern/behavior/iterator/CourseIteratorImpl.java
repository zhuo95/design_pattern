package com.zz.design_pattern.pattern.behavior.iterator;

import java.util.List;

public class CourseIteratorImpl implements CourseIterator {

    private List courseList;
    int p;

    public CourseIteratorImpl(List courseList) {
        this.courseList = courseList;
        p = 0;
    }


    @Override
    public Course nextCourse() {
        return (Course) courseList.get(p++);
    }

    @Override
    public boolean hasNextCourse() {
        return p<courseList.size();
    }
}
