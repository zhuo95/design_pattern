package com.zz.design_pattern.pattern.behavior.iterator;

public class Test {
    public static void main(String[] args) {
        Course a = new Course("a");
        Course b = new Course("b");
        Course c = new Course("c");

        CourseAggregate ca = new CourseAggregateImpl();

        ca.addCourse(a);
        ca.addCourse(b);
        ca.addCourse(c);

        CourseIterator iterator = ca.getCourseIterator();

        while(iterator.hasNextCourse()){
            System.out.println(iterator.nextCourse().getName());
        }
    }
}
