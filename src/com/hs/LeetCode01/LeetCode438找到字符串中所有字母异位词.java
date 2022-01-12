package com.hs.LeetCode01;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路：首先滑动窗口问题，关键点就是如何判断这个滑动窗口左右什么时候移动
 * 首先把p放进数组里，统计字符出现次数 + 1
 * 在主串中判断，主串这个字符在数组中，如果出现了则数组中这个次数 - 1，右边继续右移，如果这个字符在数组中次数已经为0了，说明之前出现的次数已经够了
 * 如果没有出现，则左边的字符在数组中出现次数 + 1，同时左边右移
 * 临界条件，l - r + 1 = 子串长度，说明已经满足题意了
 * @Author heshang.ink
 * @Date 2019/7/30 15:18
 */
public class LeetCode438找到字符串中所有字母异位词 {
	public List<Integer> findAnagrams(String s, String p) {
		ArrayList<Integer> list = new ArrayList<>();
		if (s.length() == 0) {
			return list;
		}
		int[] freq = new int[256];
		//把这个字母放进数组，统计字符出现次数
		for (int i = 0; i < p.length(); i++) {
			freq[p.charAt(i)]++;
		}
		int l = 0, r = -1;
		while (l < s.length()) {
			if (r + 1 < s.length() && freq[s.charAt(r + 1)] > 0) {
				r++;
				freq[s.charAt(r)]--;
			} else {
				freq[s.charAt(l)]++;
				l++;
			}
			if ((r - l + 1) == p.length()) {
				list.add(l);
			}
		}
		return list;
	}
}
