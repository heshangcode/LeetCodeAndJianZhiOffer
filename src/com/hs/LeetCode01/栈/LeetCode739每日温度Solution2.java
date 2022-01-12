package com.hs.LeetCode01.栈;

import java.util.Stack;

/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 *
 * 思路1：暴力
 * 思路2：利用单调栈，栈存下标
 * @Author heshang.ink
 * @Date 2019/10/27 10:40
 */
public class LeetCode739每日温度Solution2 {
	public int[] dailyTemperatures(int[] arr) {
		int[] res = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			//入栈的情况
			if (stack.isEmpty()) {
				stack.push(i);
			} else if (arr[i] <= arr[stack.peek()]) {
				stack.push(i);
			} else {
				//出栈栈顶元素进行比较了
				while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
					res[stack.peek()] = i - stack.peek();
					stack.pop();
				}
				//要记得把这个元素放进去哦
				stack.push(i);
			}
		}
		return res;
	}
}
