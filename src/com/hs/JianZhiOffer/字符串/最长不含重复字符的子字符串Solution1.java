package com.hs.JianZhiOffer.字符串;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 * 假设字符串中只包含从’a’到’z’的字符。
 * <p>
 * 样例
 * 输入："abcabc"
 * <p>
 * 输出：3
 * <p>
 * 思路：双指针，滑动窗口思路
 *
 * @Author heshang.ink
 * @Date 2019/10/9 9:57
 */
public class 最长不含重复字符的子字符串Solution1 {
	public int longestSubstringWithoutDuplication(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int left = 0, right = -1;  //[i,j]
		int res = 0;
		int[] nums = new int[256];  //存字符出现的次数
		while (left < s.length()) {
			//判断字符有没有出现过
			if (right + 1 < s.length() && nums[s.charAt(right + 1)] == 0) {
				right++;
				nums[s.charAt(right)]++;
			} else {
				//出现过了，把左边出现的值取消一次，然后左边进行右移
				nums[s.charAt(left)]--;
				left++;
			}
			res = Math.max(res, right - left + 1);
		}
		return res;

	}
}
