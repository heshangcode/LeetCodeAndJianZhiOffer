package com.hs.LeetCode02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/1/12 10:54
 * version: 1.0
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
        Stack<Character> stack = new Stack<>();
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    List<Integer> list;
    int minIndex;




    public void push(int val) {
        list.add(val);
        if (list.size() == 0) {
            minIndex = 0;
        } else if (val < list.get(minIndex)) {
            minIndex = list.indexOf(val);
        }

    }

    public void pop() {
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return list.get(minIndex);
    }
}
