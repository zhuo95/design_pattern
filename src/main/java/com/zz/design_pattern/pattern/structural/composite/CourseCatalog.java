package com.zz.design_pattern.pattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class CourseCatalog extends CatalogComponent {
    private List<CatalogComponent> items = new ArrayList<CatalogComponent>();
    private Integer level;

    private String name;

    public CourseCatalog(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public String getName(CatalogComponent catalogComponent) {
        return this.name;
    }

    @Override
    public void add(CatalogComponent catalogComponent) {
        items.add(catalogComponent);
    }

    @Override
    public void remove(CatalogComponent catalogComponent) {
       items.remove(catalogComponent);
    }

    /**
     * 这里有个坑，组合模式的缺点，难以区别组合的对象到底是谁，这里用level区别
     */
    @Override
    public void print() {
        System.out.println(this.name);
        for (CatalogComponent catalogComponent: items){
            if (this.level!=null){
                for (int i=0;i<this.level;i++){
                    System.out.print("    ");
                }
            }
            catalogComponent.print();
        }
    }
}
