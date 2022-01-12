package com.hs.LeetCode01;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 思路：滑动窗口，关键点如何比较两个字符串谁的长度短
 *
 * @Author heshang.ink
 * @Date 2019/7/30 15:43
 */
public class LeetCode76最小覆盖子串 {
	public static String minWindow(String s, String t) {
		if (s.length() == 0 || t.length() == 0) {
			return "";
		}
		int l = 0, r = -1;
		int[] sFreq = new int[256];    //存s串出现的字符出现次数
		//int[] tFreq = new int[26];   //这里建26存字母，小写字母 - 'a'之后的值， 存t需要的字符
		int[] tFreq = new int[256];
		for (int i = 0; i < t.length(); i++) {
			tFreq[t.charAt(i)]++;
		}
		int sCnt = 0;   //滑动窗口里字母满足t串的字母个数
		int minLength = s.length();
		int startIndex = -1;    //s.subString(startIndex,minLength)满足字符串
		while (l < s.length()) {
			//首先判断这个滑动窗口里字母满足了t的要求不
			if (r + 1 < s.length() && sCnt < t.length()) {
				//不满足，右边的继续右移
				r++;
				//放入s串的sFreq
				sFreq[s.charAt(r)]++;
				//比如s:EBBANCF,t:ABC,第一次的时候，s串数组E在t串数组中E需要0，这样就是不满足
				if (sFreq[s.charAt(r)] <= tFreq[s.charAt(r)]) {
					//比较s串中的字母是不是满足t串需要的字母
					//t串要的字母 个数 大于 s串的字母，
					sCnt++;
				}

			} else {
				//滑动窗口里的字母满足了，找到解了，但是这里就是为了找到最优解，左边右移
				if (sCnt == t.length() && r - l + 1 <= minLength) {
					minLength = r - l + 1;
					startIndex = l;
				}
				sFreq[s.charAt(l)]--;
				if (sFreq[s.charAt(l)] < tFreq[s.charAt(l)]) {
					sCnt--;
				}
				l++;
			}
		}
		if (startIndex != -1) {
			return s.substring(startIndex, startIndex + minLength);
		}
		return "";

	}

	public static void main(String[] args) {
		//System.out.println(minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(minWindow("a", "a"));
	}
}
