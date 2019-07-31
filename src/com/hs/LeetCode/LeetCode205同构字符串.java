package com.hs.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路：跟290一样，两个字符串的规律
 * @Author heshang.ink
 * @Date 2019/7/31 14:57
 */
public class LeetCode205同构字符串 {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		Map<Character, Integer> sMap = new HashMap<>();
		Map<Character, Integer> tMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (!sMap.containsKey(s.charAt(i))) {
				sMap.put(s.charAt(i), i);
			}
			if (!tMap.containsKey(t.charAt(i))) {
				tMap.put(t.charAt(i), i);
			}
			int a = sMap.get(s.charAt(i));
			int b = tMap.get(t.charAt(i));
			if (a != b) {
				return false;
			}
		}
		return true;
	}

}
