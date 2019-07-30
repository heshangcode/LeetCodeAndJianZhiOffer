package com.hs.LeetCode;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/4/8 10:21
 */
public class 验证回文串 {
	public static void main(String[] args) {

		boolean palindrome = isPalindrome("A man, a plan, a canal: Panama");
		System.out.println(palindrome);
	}

	public static boolean isPalindrome(String s) {
		s = s.toLowerCase();
		String replace = "";
		for (char c : s.toCharArray()) {
			if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
				replace += c;
			}
		}
		if ("".equals(replace)) {
			return true;
		} else {
			int length = replace.length();
			char[] str1 = replace.substring(0, length / 2).toCharArray();
			String str2 = "";
			if (length % 2 != 0) {
				str2 = replace.substring(length / 2 + 1, length);
			} else {
				str2 = replace.substring(length / 2 , length);
			}

			String str3 = "";
			for (int i = str1.length - 1; i >= 0; i--) {
				str3 += str1[i];
			}
			return str3.equals(str2);
		}

	}
}
