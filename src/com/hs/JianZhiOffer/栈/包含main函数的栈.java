package com.hs.JianZhiOffer.栈;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * 链接：https://leetcode-cn.com/problems/min-stack
 *
 * @Author heshang.ink
 * @Date 2019/10/3 10:16
 */
public class 包含main函数的栈 {
	Stack<Integer> data = new Stack<>();
	Stack<Integer> min = new Stack<>();

	public void push(int node) {
		data.add(node);
		if (min.isEmpty() || node <= min.peek()) {
			min.add(node);
		}
	}

	public void pop() {
		if (!data.isEmpty()) {
			int pop = data.pop();
			if (pop == min.peek()) {
				min.pop();
			}
		}
	}

	public int top() {

		return data.peek();
	}

	public int min() {

		return min.peek();
	}

}
