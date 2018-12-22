package com.zz.design_pattern.design_principle.singleresponsibility;

public class Bird {
    public void mainMoveMode(String birdName){
        if("鸵鸟".equals(birdName)){
            System.out.println(birdName+" walk");
        }else
        System.out.println(birdName + " fly");
    }

}
