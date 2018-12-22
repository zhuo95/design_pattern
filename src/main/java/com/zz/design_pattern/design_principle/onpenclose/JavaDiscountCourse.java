package com.zz.design_pattern.design_principle.onpenclose;

public class JavaDiscountCourse extends JavaCourse {
    public JavaDiscountCourse(Integer id, Double price, String name) {
        super(id, price, name);
    }

    public Double getOriginalPrice(){
        return super.getPrice();
    }

    @Override
    public Double getPrice() {
        return super.getPrice()*0.8;
    }
}
