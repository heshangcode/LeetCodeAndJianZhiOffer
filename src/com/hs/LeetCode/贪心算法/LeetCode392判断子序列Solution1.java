package com.hs.LeetCode.贪心算法;

/**
 * 思路1：i为s的下标，j为t的下标，依次比较两个字符是否相等，相等，i，j后移，不相同，i不移动，j后移
 *
 * @Author heshang.ink
 * @Date 2019/9/22 20:08
 */
public class LeetCode392判断子序列Solution1 {
	public boolean isSubsequence(String s, String t) {
		int i = 0, j = 0;
		while (i < s.length() && j < t.length()) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
				j++;
			} else {
				j++;
			}
		}
		if (i == s.length()) {
			return true;
		}
		return false;
	}
}
