package com.zz.design_pattern.design_principle.demeter;

import java.util.ArrayList;
import java.util.List;

public class TeamLeader {
    public void checkCourseNum(){
        List<Course> courseList = new ArrayList<>();
        for(int i=0;i<20;i++){
            courseList.add(new Course());
        }
        System.out.println(courseList.size());
    }
}
