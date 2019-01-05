package com.zz.design_pattern.pattern.creational.prototype.clone;

import java.util.Date;

public class Pig implements Cloneable{
    private String name;
    private Date birthday;

    @Override
    public String toString() {
        return "Pig{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}'+ super.toString();
    }

    public Pig(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    //浅克隆
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

//    //深克隆
//    @Override
//   protected Object clone() throws CloneNotSupportedException {
//        Pig pig = (Pig) super.clone();
//        pig.birthday = (Date) pig.birthday.clone();
//        return pig;
//   }
}
