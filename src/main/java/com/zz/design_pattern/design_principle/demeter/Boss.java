package com.zz.design_pattern.design_principle.demeter;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    //course 不是boss的朋友类,因为它在方法的内部
    public void commandCheckNumber(TeamLeader teamLeader){
//        List<Course> courseList = new ArrayList<>();
//        for(int i=0;i<20;i++){
//            courseList.add(new Course());
//        }
        teamLeader.checkCourseNum();
    }
}
