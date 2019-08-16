package com.hs.LeetCode.栈;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 思路：栈：如果需要找最近的元素，最好用栈
 * 如果是( [ {入栈，)]}比较栈顶，然后找到匹配的了，出栈，没有就false
 *
 * @Author heshang.ink
 * @Date 2019/8/16 11:14
 */
public class LeetCode20有效的括号 {
	public static boolean isValid(String s) {
		if (s.length() == 0) {
			return true;
		}
		if (s.length() == 1) {
			return false;
		}
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				//入栈
				stack.push(c);
			} else {
				//是闭括号，比较
				if (stack.isEmpty()) {
					return false;
				}
				Character top = stack.pop();
				Character match = null;
				if (c == ')') {
					match = '(';
				}
				if (c == ']') {
					match = '[';
				}
				if (c == '}') {
					match = '{';
				}
				if (!top.equals(match)) {
					return false;
				}
			}
		}
		if (!stack.isEmpty()) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isValid("([]"));
	}
}
