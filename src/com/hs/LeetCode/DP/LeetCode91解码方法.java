package com.hs.LeetCode.DP;

import java.util.Arrays;

/**
 * 思路1：dfs，暴力，肯定会重复计算，有点类似斐波那契数列
 * 思路2：自顶向下，记忆化搜索，发现思路1很多地方重复计算
 * 思路3：改为自底向上，DP
 *
 * @Author heshang.ink
 * @Date 2019/9/7 18:17
 */
public class LeetCode91解码方法 {
	/**
	 * 思路1：dfs，暴力，肯定会重复计算，有点类似斐波那契数列
	 *
	 * @param s
	 * @return
	 */
	public int numDecodings(String s) {
		if (s.length() == 0) {
			return 0;
		}
		return dfs(s, 0);
	}

	private int dfs(String s, int start) {
		if (start == s.length()) {
			return 1;
		}
		//特殊情况，如果这个值为0，没有字符可以匹配
		if (s.charAt(start) == '0') {
			return 0;
		}
		//每次枚举一个字符
		int ans1 = dfs(s, start + 1);
		int ans2 = 0;
		if (start < s.length() - 1) {
			int ten = (s.charAt(start) - '0') * 10;
			int one = (s.charAt(start + 1) - '0');
			if (ten + one <= 26) {
				ans2 = dfs(s, start + 2);
			}
		}

		return ans1 + ans2;
	}

	int[] dp;

	/**
	 * 思路2：自顶向下，记忆化搜索，发现思路1很多地方重复计算
	 *
	 * @param s
	 * @return
	 */
	public int numDecodings2(String s) {
		if (s.length() == 0) {
			return 0;
		}
		dp = new int[s.length()];
		Arrays.fill(dp, -1);
		return dfs2(s, 0);
	}

	private int dfs2(String s, int start) {
		if (start == s.length()) {
			return 1;
		}
		if (s.charAt(start) == '0') {
			return 0;
		}
		if (dp[start] != -1) {
			return dp[start];
		}
		int res = dfs2(s, start + 1);
		if (start + 1 < s.length()) {
			int ten = (s.charAt(start) - '0') * 10;
			int one = (s.charAt(start + 1) - '0');
			if (ten + one <= 26) {
				res += dfs2(s, start + 2);
			}
		}
		dp[start] = res;
		return dp[start];
	}

	public int numDecodings3(String s) {
		if (s.charAt(0) == '0') {
			return 0;
		}

		int[] dp = new int[s.length() + 1];
		dp[0] = dp[1] = 1;

		for (int i = 2; i <= s.length(); i++) {
			//如果该位不为'0'，说明该位单独成字母合法
			if (s.charAt(i - 1) != '0') {
				dp[i] += dp[i - 1];
			}
			//如果后两位能组成"1x"（x为任意数字）或者"2x"（x小于7），说明最后两位组成字母合法
			if ((s.charAt(i - 2) == '1') || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[s.length()];
	}
}
