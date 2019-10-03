package com.hs.JianZhiOffer.栈;

import java.util.Stack;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/9/23 20:57
 */
public class 用两个栈实现队列 {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.add(node);
	}

	public int pop() {
		while (!stack1.isEmpty()) {
			stack2.add(stack1.pop());
		}
		int pop = stack2.pop();
		while (!stack2.isEmpty()) {
			stack1.add(stack2.pop());
		}
		return pop;
	}


}
