package com.hs.JianZhiOffer.字符串;

import java.util.HashMap;
import java.util.Map;

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
 * 思路2：双指针，记录字符出现的下标，如果出现重复的直接跳过去
 *
 * @Author heshang.ink
 * @Date 2019/10/9 9:57
 */
public class 最长不含重复字符的子字符串Solution2 {
	public int longestSubstringWithoutDuplication(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int res = 0;
		Map<Character, Integer> map = new HashMap<>();  //定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
		for (int i = 0, j = 0; j < s.length(); j++) {
			char alpha = s.charAt(j);
			if (map.containsKey(alpha)) {
				i = Math.max(map.get(alpha), i);
			}
			res = Math.max(res, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return res;
	}
}
