package com.zz.design_pattern.pattern.structural.bridge;

//抽象和实现分离
// 将实现部分的 account实现类 和 抽象部分的bank 分离
public abstract class Bank  {
    protected Account account; // 核心 用组合使用接口
    public Bank(Account account){
        this.account = account;
    }

    //与接口中的方法一样
    abstract Account openAccount();
}
