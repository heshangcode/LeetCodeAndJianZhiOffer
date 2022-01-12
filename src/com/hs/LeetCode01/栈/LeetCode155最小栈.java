package com.hs.LeetCode01.栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack/solution/shi-yong-fu-zhu-zhan-tong-bu-he-bu-tong-bu-python-/
 *
 * @Author heshang.ink
 * @Date 2019/9/23 21:28
 */
public class LeetCode155最小栈 {
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> minStack = new Stack<>();

	public void push(int x) {
		stack.add(x);
		if (minStack.isEmpty() || x <= minStack.peek()) {
			minStack.add(x);
		}
	}

	public void pop() {
		if (!stack.isEmpty()) {
			int pop = stack.pop();
			if (pop == minStack.peek()) {
				minStack.pop();
			}
		}

	}

	public int top() {
		if (!stack.isEmpty()) {
			return stack.peek();
		}
		throw new RuntimeException("错误");
	}

	public int getMin() {
		if (!minStack.isEmpty()) {
			return minStack.peek();
		}
		throw new RuntimeException("错误");
	}
}
