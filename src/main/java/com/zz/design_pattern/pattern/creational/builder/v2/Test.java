package com.zz.design_pattern.pattern.creational.builder.v2;


import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableSet;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 链式调用
 */
public class Test {
    public static void main(String[] args) {
        Course course = new Course.CourseBuilder().buildNmae("课程2").buildNote("note2")
                .buildPPT("PPT2").buildQA("QA2").buildVideo("video2").build();
        System.out.println(course);

        //guava 中间建造者
        Set<String> set = ImmutableSet.<String>builder().add("a").add("b").add("c").build();

        //guava cache 初始1000条目 concurrencyLevel设置并发数
        LoadingCache<String, String> loacalCache = CacheBuilder.newBuilder().initialCapacity(1000)
                .maximumSize(10000).expireAfterAccess(12, TimeUnit.HOURS).concurrencyLevel(5)
                .build(new CacheLoader<String, String>() {
                    //默认的数据加载实现，当get取值的时候，如果key没有对应值，就调用这个方法加载
                    @Override
                    public String load(String s) throws Exception {
                        return "null";
                    }
                });
    }
}
