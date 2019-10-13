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
 * @Author heshang.ink
 * @Date 2019/10/13 11:11
 */
public class 左旋转字符串Solution1 {
	public String leftRotateString(String str, int n) {
		if (n >= str.length()) {
			return "";
		}
		return str.substring(n, str.length()) + str.substring(0, n);
	}
}
