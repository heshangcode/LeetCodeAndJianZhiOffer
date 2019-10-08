package com.hs.JianZhiOffer.DP;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * <p>
 * 0翻译成”a”，1翻译成”b”，……，11翻译成”l”，……，25翻译成”z”。
 * <p>
 * 一个数字可能有多个翻译。例如12258有5种不同的翻译，它们分别是”bccfi”、”bwfi”、”bczi”、”mcfi”和”mzi”。
 * <p>
 * 请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 样例
 * 输入："12258"
 * <p>
 * 输出：5
 * <p>
 * 思路：dp解决
 *
 * @Author heshang.ink
 * @Date 2019/10/8 20:55
 */
public class 把数字翻译成字符串Solution2 {
	public int StrToInt(String str) {
		if (str.length() == 0) {
			return 0;
		}
		if (str.charAt(0) == '0') {
			return 0;
		}

		int[] dp = new int[str.length() + 1];
		dp[0] = dp[1] = 1;
		for (int i = 2; i <= str.length(); i++) {
			//如果该位不为‘0’，说明该位单独成字母合法
			if (str.charAt(i - 1) != '0') {
				dp[i] += dp[i - 1];
			}
			//如果后两位能组成"1x"（x为任意数字）或者"2x"（x小于7），说明最后两位组成字母合法
			if ((str.charAt(i - 2) == '1') || (str.charAt(i - 2) == '2'
					&& str.charAt(i - 1) <= '6')) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[str.length()];
	}

}
