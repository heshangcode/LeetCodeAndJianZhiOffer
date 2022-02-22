package com.hs.JianZhiOffer02.栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/12 17:52
 * version: 1.0
 */
public class 用两个栈实现队列 {
    Deque<Integer> pushStack = new ArrayDeque<>();
    Deque<Integer> popStack = new ArrayDeque<>();
    Deque<Integer> stack = new ArrayDeque<>();

    //public CQueue() {
    //
    //}

    public void appendTail(int value) {
        pushStack.push(value);
    }

    public int deleteHead() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        if (popStack.isEmpty()) {
            return -1;
        } else {
            return pushStack.pop();
        }
    }
}
