package com.zz.design_pattern.pattern.creational.prototype.clone;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date();
        Pig pig1 = new Pig("佩奇", date);
        Pig pig2 = (Pig) pig1.clone();
        //Pig{name='佩奇', birthday=Fri Jan 04 19:38:06 EST 2019}com.zz.design_pattern.pattern.creational.prototype.clone.Pig@5674cd4d
       // Pig{name='佩奇', birthday=Fri Jan 04 19:38:06 EST 2019}com.zz.design_pattern.pattern.creational.prototype.clone.Pig@63961c42
        //所以是两个对象
        System.out.println(pig1);
        System.out.println(pig2);

        // pig1 和 pig2 都修改了时间
        //因为他们的date引用的是同一个对象
        //   浅克隆
        pig1.getBirthday().setTime(0L);
        System.out.println(pig1);
        System.out.println(pig2);

    }


}
