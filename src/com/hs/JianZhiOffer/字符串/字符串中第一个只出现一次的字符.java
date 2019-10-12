package com.hs.JianZhiOffer.字符串;

/**
 * 在字符串中找出第一个只出现一次的字符。
 *
 * 如输入"abaccdeff"，则输出b。
 *
 * 如果字符串中不存在只出现一次的字符，返回#字符。
 *
 * 样例：
 * 输入："abaccdeff"
 *
 * 输出：'b'
 *
 * @Author heshang.ink
 * @Date 2019/10/10 9:15
 */
public class 字符串中第一个只出现一次的字符 {
	public int FirstNotRepeatingChar(String str) {
		if (str == null || str.length() == 0) {
			return -1;
		}
		//存出现次数
		int[] res = new int[256];
		for (int i = 0; i < str.length(); i++) {
			res[str.charAt(i)]++;
		}
		for (int i = 0; i < str.length(); i++) {
			if (res[str.charAt(i)] == 1) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new 字符串中第一个只出现一次的字符().FirstNotRepeatingChar("google"));
	}
}
