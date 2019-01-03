package com.zz.design_pattern.pattern.creational.singleton;


import java.io.*;

/**
 * 防止反射的单例模式（反射可以修改类，破坏单例）
 *
 */
public enum EnumInstance {
    INSTANCE{
        //在枚举类中申明方法
        protected void print(){
            System.out.println("zz");
        }
    };

    protected abstract void print();

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data){
        this.data = data;
    }

    public static EnumInstance getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //测试序列化的时候是不是同一个instance
        EnumInstance instance =  EnumInstance.getInstance();
        instance.setData(new Object());

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Enum"));
        oos.writeObject(instance);

        File file = new File("Enum");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        EnumInstance newInstance = (EnumInstance) ois.readObject();
        System.out.println(instance.getData() == newInstance.getData());

        instance.print();
    }
}
