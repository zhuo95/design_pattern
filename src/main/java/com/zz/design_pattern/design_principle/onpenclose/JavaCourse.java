package com.zz.design_pattern.design_principle.onpenclose;

public class JavaCourse implements ICourse {
    private Integer Id;
    private Double price;
    private String name;

    public JavaCourse(Integer id, Double price, String name) {
        Id = id;
        this.price = price;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return this.Id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
