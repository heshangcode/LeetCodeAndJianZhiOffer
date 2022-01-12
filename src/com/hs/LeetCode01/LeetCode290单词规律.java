package com.hs.LeetCode01;

import java.util.HashMap;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路：用两个map，分别存储两个字符串的位置信息
 *
 * @Author heshang.ink
 * @Date 2019/7/31 14:39
 */
public class LeetCode290单词规律 {
	public static boolean wordPattern(String pattern, String str) {
		String[] strings = str.split(" ");
		if (strings.length != pattern.length()) {
			return false;
		}
		//存pattern
		HashMap<Character, Integer> map1 = new HashMap<>();
		//存strings
		HashMap<String, Integer> map2 = new HashMap<>();

		for (int i = 0; i < strings.length; i++) {
			if (!map1.containsKey(pattern.charAt(i))) {
				map1.put(pattern.charAt(i), i);
			}
			if (!map2.containsKey(strings[i])) {
				map2.put(strings[i], i);
			}
			//接下来判断两个字符串里的规律了
			int a = map1.get(pattern.charAt(i));
			int b = map2.get(strings[i]);
			if (a != b) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(wordPattern("abba", "dog cat cat dog"));
	}

}
