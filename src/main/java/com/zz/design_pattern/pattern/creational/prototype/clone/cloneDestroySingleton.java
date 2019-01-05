package com.zz.design_pattern.pattern.creational.prototype.clone;

import com.zz.design_pattern.pattern.creational.singleton.HungrySingleton;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * 解决方法：单例类重写clone方法 返回instance 单例
 */
public class cloneDestroySingleton {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();

        Method method = hungrySingleton.getClass().getDeclaredMethod("clone");
        method.setAccessible(true);
        HungrySingleton cloneHungrySingleton = (HungrySingleton) method.invoke(hungrySingleton);
    }
}
