package com.hs.JianZhiOffer.DP;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 *
 * 0翻译成”a”，1翻译成”b”，……，11翻译成”l”，……，25翻译成”z”。
 *
 * 一个数字可能有多个翻译。例如12258有5种不同的翻译，它们分别是”bccfi”、”bwfi”、”bczi”、”mcfi”和”mzi”。
 *
 * 请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。
 *
 * 样例
 * 输入："12258"
 *
 * 输出：5
 *
 * 思路：dfs，每次分一个出来 + 分二个出来
 * @Author heshang.ink
 * @Date 2019/10/8 20:55
 */
public class 把数字翻译成字符串Solution1 {
	public int StrToInt(String str) {
		if (str.length() == 0) {
			return 0;
		}
		return dfs(str, 0);
	}

	private int dfs(String str, int index) {

		if (str.length() == index) {
			return 1;
		}
		//每次枚举一个字符
		int res1 = dfs(str, index + 1);
		int res2 = 0;
		//判断是否可以枚举两个字符
		if (index < str.length() - 1) {
			int ten = (str.charAt(index) - '0') * 10;
			int one = (str.charAt(index + 1) - '0');
			if (ten + one <= 25) {
				res2 = dfs(str, index + 2);
			}
		}
		return res1 + res2;
	}
}
