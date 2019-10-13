package com.hs.JianZhiOffer.字符串;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * <p>
 * 请定义一个函数实现字符串左旋转操作的功能。
 * <p>
 * 比如输入字符串"abcdefg"和数字2，该函数将返回左旋转2位得到的结果"cdefgab"。
 * <p>
 * 注意：
 * <p>
 * 数据保证n小于等于输入字符串的长度。
 * 样例
 * 输入："abcdefg" , n=2
 * <p>
 * 输出："cdefgab"
 *
 * 思路：
 * 1.首先把整个字符反转
 * 2.把0-k，k-len 分别反转
 * @Author heshang.ink
 * @Date 2019/10/13 11:11
 */
public class 左旋转字符串Solution2 {
	public String leftRotateString(String str, int n) {
		if (n > str.length()) {
			return "";
		}
		//反转整个串
		String reverse = reverse(str);
		//System.out.println(reverse);
		//分别反转0-k，k-len的字符
		String first = reverse.substring(0, str.length() - n);
		String second = reverse.substring(str.length() - n, str.length());
		return reverse(first) + reverse(second);
	}

	public String reverse(String s) {
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString();
	}
}
