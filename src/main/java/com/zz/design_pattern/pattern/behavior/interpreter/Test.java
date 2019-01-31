package com.zz.design_pattern.pattern.behavior.interpreter;

public class Test {
    public static void main(String[] args) {
        String zzInputString = "6 100 11 + *";
        ZZExpressionparse zz = new ZZExpressionparse();
        int res = zz.parse(zzInputString);
        System.out.println(res);
    }
}
