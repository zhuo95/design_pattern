package com.zz.design_pattern.pattern.behavior.interpreter;

import java.util.Stack;

public class ZZExpressionparse {
    private Stack<Interpreter> stack = new Stack<>();

    public int parse(String str){
        String[] arr = str.split(" ");
        for(String s: arr){
            if(!s.equals("+")&&!s.equals("*")&&!s.equals("-")&&!s.equals("/")){
                //不是符号
                Interpreter number = new NumberInterpreter(s);
                stack.push(number);
            }else{
                Interpreter first = stack.pop();
                Interpreter second = stack.pop();
                if (s.equals("+")){
                    Interpreter oper = new AddInterpreter(first,second);
                    stack.push(oper);
                }else {
                    // *
                    Interpreter oper = new MultiInterpreter(first,second);
                    stack.push(oper);
                }
            }
        }
        return stack.pop().interpret();
    }
}
