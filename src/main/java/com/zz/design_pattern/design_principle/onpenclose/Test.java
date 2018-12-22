package com.zz.design_pattern.design_principle.onpenclose;

import lombok.extern.slf4j.Slf4j;

/**
 * 要增加一个打折的方法
 * 如果直接修改接口和类的话不好，违反了开闭原则
 * 因此我们新建一个类来继承，在新建的类中实现打折
 * 这样的话就关闭了修改接口和父类，开放了修改扩展
 */


@Slf4j
public class Test {
    public static void main(String[] args) {
        ICourse javaCourse = new JavaDiscountCourse(96,333d,"ZZ");
        log.info("course id: {},course name: {}, course price:{}",javaCourse.getId(),javaCourse.getName(),javaCourse.getPrice());

        JavaDiscountCourse javaDiscountCourse = (JavaDiscountCourse) javaCourse;

        log.info("course original price:{}, discount price:{}", javaDiscountCourse.getOriginalPrice(),javaDiscountCourse.getPrice());
    }
}
