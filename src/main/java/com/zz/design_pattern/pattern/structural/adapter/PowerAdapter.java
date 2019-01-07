package com.zz.design_pattern.pattern.structural.adapter;

public class PowerAdapter implements DC5 {
    private AC220 ac220 = new AC220();

    @Override
    public int outputDC5V() {
        int adapterInput = ac220.outputAC220V();
        //变压器...
        int adapterOutput = adapterInput/44;

        System.out.println("输入交流电"+ adapterInput + " 输出直流电"+ adapterOutput);
        return adapterOutput;
    }
}
