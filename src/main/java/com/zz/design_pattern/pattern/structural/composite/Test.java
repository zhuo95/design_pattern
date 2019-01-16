package com.zz.design_pattern.pattern.structural.composite;

public class Test {
    public static void main(String[] args) {
        CatalogComponent linuxCourse = new Course("linux course", 10);
        CatalogComponent windowsCourse = new Course("windows course", 20);

        CatalogComponent javaCourseCatalog = new CourseCatalog("java",2);
        CatalogComponent javaCourse1 = new Course("java 1", 30);
        CatalogComponent javaCourse2 = new Course("java 2", 50);
        javaCourseCatalog.add(javaCourse1);
        javaCourseCatalog.add(javaCourse2);

        CatalogComponent imoocCourseCatalog = new CourseCatalog("慕课网网课",1);

        imoocCourseCatalog.add(linuxCourse);
        imoocCourseCatalog.add(windowsCourse);
        // add 即可添加课程 也可以添加目录 减少了在使用过程中的差异性！！！
        imoocCourseCatalog.add(javaCourseCatalog);

        imoocCourseCatalog.print();
    }
}
