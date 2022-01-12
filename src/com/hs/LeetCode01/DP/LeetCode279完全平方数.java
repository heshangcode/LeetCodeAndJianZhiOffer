package com.hs.LeetCode01.DP;

/**
 * 思路1：类比343的思路2，自顶向下思考
 * Math.min(res, 1 + dp(n - i * i))，这个如何推出的？？
 * eg 12
 * i = 1,12-1=11,相当于在11里继续找
 * i = 2,
 * 思路2：自底向上 DP
 *
 * @Author heshang.ink
 * @Date 2019/9/6 17:13
 */
public class LeetCode279完全平方数 {
	int[] memo;

	public int numSquares(int n) {
		if (n < 2) {
			return 1;
		}
		memo = new int[n + 1];
		return dp1(n);
	}

	private int dp1(int n) {

		if (n == 0) {
			return 0;
		}

		if (memo[n] != 0) {
			return memo[n];
		}
		int res = Integer.MAX_VALUE;

		for (int i = 1; n - i * i >= 0; i++) {
			res = Math.min(res, 1 + dp1(n - i * i));
		}
		memo[n] = res;
		return memo[n];
	}

	public int numSquares2(int n) {
		if (n < 1) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[0] = 0;
		//注意边界条件
		for (int i = 1; i <= n; i++) {
			//依次枚举1 - n的数
			dp[i] = i;
			for (int j = 1; i - j * j >= 0; j++) {
				//从j里面进行选择数，是否满足平方数
				//边界条件 i - j * j >= 0
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		return dp[n];

	}
}
