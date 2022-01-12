package com.hs.LeetCode01;

import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路：查找表相关问题：
 * 利用map里统计s串中字符出现次数来比较t串
 * 也可以利用数组解决问题
 * @Author heshang.ink
 * @Date 2019/7/31 10:29
 */
public class LeetCode242有效的字母异位词 {
	public static boolean isAnagram1(String s, String t) {
		if (t.length() != s.length()) {
			return false;
		}
		HashMap<Character, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (!hashMap.containsKey(s.charAt(i))) {
				hashMap.put(s.charAt(i), 1);
			} else {
				hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
			}
		}
		for (int i = 0; i < t.length(); i++) {
			if (hashMap.containsKey(t.charAt(i)) && hashMap.get(t.charAt(i)) > 0) {
				hashMap.put(t.charAt(i), hashMap.get(t.charAt(i)) - 1);
			} else {
				return false;
			}
		}
		return true;
	}

	public static boolean isAnagram2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] freq = new int[26];//说了是小写字母，所以用26存放
		//一次遍历
		for (int i = 0; i < s.length(); i++) {
			freq[s.charAt(i) - 'a']++;
			freq[t.charAt(i) - 'a']--;
		}
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isAnagram1("anagram", "nagaram"));
	}
}
