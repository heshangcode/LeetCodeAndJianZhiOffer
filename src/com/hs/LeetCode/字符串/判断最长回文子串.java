package com.hs.LeetCode.字符串;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/10/7 9:35
 */
public class 判断最长回文子串 {
	public int longestPalindrome(String s) {
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			// 以s[i]为中心的最长回文子串
			String s1 = split(s, i, i);
			// 以s[i]和s[i + 1]为中心的最长回文子串
			String s2 = split(s, i, i + 1);
			res = res.length() > s1.length() ? res : s1;
			res = res.length() > s2.length() ? res : s2;
		}
		return res.length();
	}

	private String split(String s, int left, int right) {
		//防止索引越界
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			// 向两边展开
			left--;
			right++;
		}
		// 返回以s[left]和s[right]为中心的最长回文串
		return s.substring(left + 1 , right);
	}

	public static void main(String[] args) {
		System.out.println(new 判断最长回文子串().longestPalindrome("abccccdd"));
	}
}
