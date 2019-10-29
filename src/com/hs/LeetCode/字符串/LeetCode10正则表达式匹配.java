package com.hs.LeetCode.字符串;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author heshang.ink
 * @Date 2019/10/29 9:24
 */
public class LeetCode10正则表达式匹配 {
	public boolean isMatch(String text, String pattern) {
		if (pattern.isEmpty()) return text.isEmpty();
		//考虑 .
		boolean first_match = (!text.isEmpty() &&
				(pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
		//只有长度大于 2 的时候，才考虑 *
		if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
			//两种情况
			//pattern 直接跳过两个字符。表示 * 前边的字符出现 0 次
			//pattern 不变，例如 text = aa ，pattern = a*，第一个 a 匹配，然后 text 的第二个 a 接着和 pattern 的第一个 a 进行匹配。表示 * 用前一个字符替代。
			return (isMatch(text, pattern.substring(2)) ||
					(first_match && isMatch(text.substring(1), pattern)));
		} else {
			return first_match && isMatch(text.substring(1), pattern.substring(1));
		}
	}
}
