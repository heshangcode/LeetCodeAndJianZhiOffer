package com.hs.LeetCode;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路1：滑动窗口，用freq[256]存放这个字符出现的次数
 *
 * @Author heshang.ink
 * @Date 2019/5/1 17:51
 */
public class LeetCode3无重复字符的最长子串 {
	public static void main(String[] args) {
		int abcabcbb = new LeetCode3无重复字符的最长子串().lengthOfLongestSubstring1("xabcabc");
		System.out.println(abcabcbb);
	}

	public int lengthOfLongestSubstring1(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int l = 0, r = -1;  //滑动窗口为s[l...r]
		int res = 0;
		int[] freq = new int[256];
		// 整个循环从 l == 0; r == -1 这个空窗口开始
		// 到l == s.size(); r == s.size()-1 这个空窗口截止
		// 在每次循环里逐渐改变窗口, 维护freq, 并记录当前窗口中是否找到了一个新的最优值
		while (l < s.length()) {
			//判断s.charAt(r + 1)是否出现过
			if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
				r++;
				freq[s.charAt(r)]++;
			} else {
				//出现过了，把左边出现的值取消一次，然后左边进行右移
				freq[s.charAt(l)]--;
				l++;
			}
			res = Math.max(res, r - l + 1);
		}

		return res;
	}


}
