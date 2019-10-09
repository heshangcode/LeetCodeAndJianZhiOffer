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
 * <p>
 * 最前面的翻译方法是保留了后面的翻译方法加上自己的 所以最后返回的是arr[0],这也就是为什么要从n-2开始遍历
 * 举个例子:2 6 5 其中每一位都是1 但是 2 2 6 在arr[0]的时候有考虑到 22这种组合在前面的基础上加上最前面我们设置
 * 的arr[n] = 1.
 *
 * @Author heshang.ink
 * @Date 2019/10/8 20:55
 */
public class 把数字翻译成字符串Solution3 {
	public int StrToInt(String str) {
		int n = str.length();
		if (n == 0) {
			return 0;
		}
		if (str.charAt(0) == '0') {
			return 0;
		}
		//f[i] 前i位能表示几种
		int[] dp = new int[n + 1];
		// 初始化边界 0位是1 1位也是1
		dp[n] = dp[n - 1] = 1;
		// 转移方程：f[i] = f[i + 1] + f[i + 2];   一个字符组成一个+两个字符组成一个
		for (int i = n - 2; i >= 0; i--) {
			//这个题跟lc不同的是，这个0是有效的
			dp[i] += dp[i + 1];
			//如果后两位能组成"1x"（x为任意数字）或者"2x"（x小于7），说明最后两位组成字母合法
			// 本题是到25 lc到26
			int num = (str.charAt(i) - '0') * 10 + (str.charAt(i + 1) - '0');
			//这种情况03 05 09就不能组成两个字符的
			if (num >= 10 && num <= 25) {
				dp[i] += dp[i + 2];
			}
		}
		return dp[0];
	}

}
