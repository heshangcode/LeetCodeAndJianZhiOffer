package com.hs.LeetCode;

/**
 * 递归翻转栈
 *
 * @Author heshang.ink
 * @Date 2019/4/1 19:28
 */

import java.util.Stack;

public class Reverse {

	private Stack<Integer> stack;

	/**
	 * 构造函数
	 */
	public Reverse() {
		stack = new Stack<>();
	}

	//压入函数
	public void push(Integer num) {
		stack.push(num);
	}

	public Integer pop() {
		return stack.pop();
	}

	/**
	 * 得到栈底值并移除
	 *
	 * @return
	 */
	private Integer getLastValue() {
		//获取当前栈顶值
		int value = stack.pop();
		//终结条件
		if (stack.isEmpty()) {
			return value;
		} else {
			//递归
			int last = getLastValue();
			//重新压入数值
			stack.push(value);
			return last;
		}
	}

	//通过递归重新把栈底值反转压入
	public void reverseStack() {
		//递归终结条件
		if (stack.isEmpty()) {
			return;
		}
		int last = getLastValue();//通过递归函数获取栈底值
		reverseStack();//递归操作
		stack.push(last);//一层一层压入值
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}
}
