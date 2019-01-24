package com.zz.design_pattern.pattern.structural.bridge;

public class Test {
    public static void main(String[] args) {
        Bank zzBank = new ZZBank(new DepositAccount());
        Account zzAccount = zzBank.openAccount();
        zzAccount.showAccountType();


        Bank abcBank = new ABCBank(new SavingAccount());
        Account abcAccount = abcBank.openAccount();
        abcAccount.showAccountType();
    }
}
