package com.hs.LeetCode;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 元音字母 a，e，i，o，u，A，E，I，O，U
 * 思路：344的变形，只是每次得判断一下是不是元音字母，
 * 元音字母用set存储
 *
 * @Author heshang.ink
 * @Date 2019/7/29 19:44
 */
public class LeetCode345反转字符串中的元音字母 {
	public static String reverseVowels(String s) {
		if (s.length() == 0) {
			return "";
		}
		HashSet<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		char[] chars = s.toCharArray();
		int l = 0, r = chars.length - 1;
		while (l < r) {
			//这里得注意l <= r到底成不成立的问题
			while (l < r && !set.contains(chars[l])) {
				l++;
			}
			while (l < r && !set.contains(chars[r])) {
				r--;
			}
			if (set.contains(chars[l]) && set.contains(chars[r])) {
				swap(chars, l, r);
				l++;
				r--;
			}

		}
		return new String(chars);
	}

	public static void swap(char[] s, int i, int j) {
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String s = reverseVowels(str);
		System.out.println(s);
	}
}
