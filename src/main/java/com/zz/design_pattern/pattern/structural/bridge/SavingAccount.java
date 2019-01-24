package com.zz.design_pattern.pattern.structural.bridge;

public class SavingAccount implements Account {
    @Override
    public Account openAccount() {
        System.out.println("打开saving account");
        return new SavingAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("saving Account");
    }
}
