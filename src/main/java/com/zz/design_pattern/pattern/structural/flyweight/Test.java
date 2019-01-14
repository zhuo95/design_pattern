package com.zz.design_pattern.pattern.structural.flyweight;


/**
 * 场景是公司员工做报告
 * 第一次做报告的时候要new，之后直接在map里取
 *
 * department 就是外部状态，传入不同的department 获得的object不同
 *
 */
public class Test {
    private static final String[] departments = new String[] {"RD","QA","PM","BD"};

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            String department = departments[(int) (Math.random()*departments.length)];
            Manager manager = (Manager) EmployeeFactory.getManager(department);
            manager.report();
        }
    }
}
