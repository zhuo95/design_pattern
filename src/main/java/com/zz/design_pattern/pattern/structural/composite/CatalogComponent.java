package com.zz.design_pattern.pattern.structural.composite;

/**
 * 课程目录
 */
public abstract class CatalogComponent {
    public void add(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持添加课程");
    }

    public void remove(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持删除课程");
    }

    public String getName(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持获取课程");
    }

    public Double getPrice(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持获取课程价格");
    }

    public void print(){
        throw new UnsupportedOperationException("不支持打印");
    }
}
