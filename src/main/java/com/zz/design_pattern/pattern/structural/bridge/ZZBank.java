package com.zz.design_pattern.pattern.structural.bridge;

public class ZZBank extends  Bank {

    public ZZBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开zz银行账号");
        return account;
    }
}
