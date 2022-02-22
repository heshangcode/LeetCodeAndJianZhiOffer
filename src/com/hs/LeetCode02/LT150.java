package com.hs.LeetCode02;

import java.util.HashSet;
import java.util.Stack;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/1/17 07:58
 * version: 1.0
 */
public class LT150 {


    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                Integer y = numStack.pop();
                Integer x = numStack.pop();
                numStack.push(calc(x, y, token));
            } else {
                numStack.push(Integer.valueOf(token));
            }
        }
        return numStack.pop();
    }

    private Integer calc(Integer x, Integer y, String token) {
        if (token.equals("+")) {
            return x + y;
        }
        if (token.equals("-")) {
            return x - y;
        }
        if (token.equals("*")) {
            return x * y;
        }
        if (token.equals("/")) {
            return x / y;
        }
        return -1;
    }



    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};

        LT150 lt150 = new LT150();
        System.out.println(lt150.evalRPN(tokens));

    }

}


