package com.zz.design_pattern.pattern.behavior.iterator;

public interface CourseAggregate {
    void addCourse(Course course);
    void removeCourse(Course course);

    CourseIterator getCourseIterator();
}
