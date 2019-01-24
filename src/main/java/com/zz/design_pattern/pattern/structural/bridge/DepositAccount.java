package com.zz.design_pattern.pattern.structural.bridge;

public class DepositAccount implements Account {
    @Override
    public Account openAccount() {
        System.out.println("打开deposit account");
        return new DepositAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("Deposit Account");
    }
}
