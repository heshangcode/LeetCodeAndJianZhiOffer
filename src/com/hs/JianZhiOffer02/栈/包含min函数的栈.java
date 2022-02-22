package com.hs.JianZhiOffer02.栈;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/13 16:56
 * version: 1.0
 */
public class 包含min函数的栈 {


    Deque<Integer> stack;
    Deque<Integer> minStack;
    //public MinStack() {
    //    stack = new ArrayDeque<>();
    //    minStack = new ArrayDeque<>();
    //    minStack.push(Integer.MAX_VALUE);
    //}

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(x, minStack.peek()));
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
