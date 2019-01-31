package com.zz.design_pattern.pattern.behavior.interpreter;

public class AddInterpreter implements Interpreter {
    private Interpreter firstExpression, secondExpress;

    public AddInterpreter(Interpreter firstExpression, Interpreter secondExpress) {
        this.firstExpression = firstExpression;
        this.secondExpress = secondExpress;
    }

    @Override
    public int interpret() {
        return this.firstExpression.interpret() + secondExpress.interpret();
    }

    @Override
    public String toString() {
        return "+";
    }
}
