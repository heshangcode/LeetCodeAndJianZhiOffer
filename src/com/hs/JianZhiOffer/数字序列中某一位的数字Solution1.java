package com.hs.JianZhiOffer;

/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * <p>
 * 在这个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。
 * <p>
 * 请写一个函数求任意位对应的数字。
 * <p>
 * 样例
 * 输入：13
 * <p>
 * 输出：1
 * <p>
 * 思路：
 * 暴力
 *
 * @Author heshang.ink
 * @Date 2019/10/7 8:57
 */
public class 数字序列中某一位的数字Solution1 {
	public int digitAtIndex(int n) {

		String str = "";
		for (int i = 0; i <= n; i++) {
			str += i;
		}
		char c = str.charAt(n);
		String res = String.valueOf(c);
		return Integer.parseInt(res);
	}

}
