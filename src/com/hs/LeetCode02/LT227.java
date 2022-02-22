package com.hs.LeetCode02;

import java.util.*;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/1/18 08:45
 * version: 1.0
 */
public class LT227 {
    public int calculate(String s) {
        // 思路
        // 1. 把中缀表达式转换为后缀表达式
        // 2. 遍历，遇见数字就加入进去，

        //让所有的数字都可以加入到后缀表达式里
        s += " ";
        Stack<Character> ops = new Stack<>();
        //每次来记录数字
        StringBuilder nums = new StringBuilder();
        // 来记录后缀表达式
        ArrayList<String> tokens = new ArrayList<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (isNumber(c)) {
                nums.append(c);
                continue;
            } else {
                if (nums.length() != 0) {
                    tokens.add(nums.toString());
                    nums = new StringBuilder();
                }
            }

            if (c == ' ') {
                continue;
            }
            int currRank = getRank(c);
            while (!ops.isEmpty() && getRank(ops.peek()) >= currRank) {
                tokens.add(String.valueOf(ops.pop()));
            }

            ops.push(c);

        }
        while (!ops.isEmpty()) {
            tokens.add(String.valueOf(ops.pop()));

        }
        System.out.println(tokens);
        return evalRPN(tokens.toArray(new String[0]));
    }

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

    int getRank(char ch) {
        if (ch == '*' || ch == '/') return 2;
        if (ch == '+' || ch == '-') return 1;
        return -1;
    }

    boolean isNumber(char c) {
        return Character.isDigit(c);
    }
}
