package com.hs.LeetCode;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/5/4 16:21
 */
public class 朴素匹配字符串 {
	public static void main(String[] args) {
		int i = strStr("aaa", "aa");
		System.out.println(i);
	}

	public static int strStr(String haystack, String needle) {
		if (needle.length() == 0) {
			return 0;
		}
		int index = 0, i = 0, j = 0;
		while (i < haystack.length() && j < needle.length()) {
			//按个字符开始比较
			if (haystack.charAt(i) == needle.charAt(j)) {
				//相同，两个下标后移
				i++;
				j++;
			} else {
				//index为了记录从哪个下标开始的
				index++;
				i = index;
				//子串从第一个开始
				j = 0;
			}
		}
		//说明子串遍历完了
		if (j == needle.length()) {
			return index;
		}

		return -1;

	}
}
