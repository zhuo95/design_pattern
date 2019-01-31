package com.zz.design_pattern.pattern.behavior.interpreter;

public class NumberInterpreter implements Interpreter {
    private int num;

    public NumberInterpreter(int num) {
        this.num = num;
    }

    public NumberInterpreter(String num) {
        this.num = Integer.parseInt(num);
    }

    @Override
    public int interpret() {
        return this.num;
    }
}
