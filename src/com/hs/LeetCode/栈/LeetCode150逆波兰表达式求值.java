package com.hs.LeetCode.栈;

import java.util.Stack;

/**
 * 根据逆波兰表示法，求表达式的值。
 * <p>
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 说明：
 * <p>
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 * <p>
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * 示例 2：
 * <p>
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * 示例 3：
 * <p>
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 * 思路：栈，如果是数字放进去，语句符号，弹出栈里两个值，和符号运算
 *
 * @Author heshang.ink
 * @Date 2019/8/16 11:32
 */
public class LeetCode150逆波兰表达式求值 {
	public int evalRPN(String[] tokens) {
		Stack<Integer> value = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			String va = tokens[i];
			if (va.equals("+") || va.equals("-") || va.equals("*") || va.equals("/")) {
				Integer b = value.pop();
				Integer a = value.pop();
				if (va.equals("+")) {
					value.push(a + b);
				}
				if (va.equals("-")) {
					value.push(a - b);
				}
				if (va.equals("*")) {
					value.push(a * b);
				}
				if (va.equals("/")) {
					value.push(a / b);
				}
			} else {
				value.push(Integer.parseInt(va));
			}
		}
		return value.pop();
	}
}
