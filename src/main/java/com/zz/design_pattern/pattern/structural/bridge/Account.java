package com.zz.design_pattern.pattern.structural.bridge;

//银行账号
//账号有不同类型
public interface Account {
    Account openAccount();
    void showAccountType();
}
