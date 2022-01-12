package com.hs.LeetCode01;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
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
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 *
 * @Author heshang.ink
 * @Date 2019/3/31 15:10
 */
public class 有效的括号 {
	public static void main(String[] args) {
		System.out.println(isValid("([]{}())"));
	}

	public static boolean isValid(String s) {

		while (s.contains("{}") || s.contains("()") || s.contains("[]")) {
			s = s.replace("{}", "");
			s = s.replace("()", "");
			s = s.replace("[]", "");
		}
		if ("".equals(s)) {
			return true;
		}else{
			return false;
		}

	}
}
