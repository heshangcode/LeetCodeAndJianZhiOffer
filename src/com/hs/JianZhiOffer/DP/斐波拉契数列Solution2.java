package com.hs.JianZhiOffer.DP;

import java.util.Arrays;

/**
 * 思路2：记忆化搜索dp
 *
 * @Author heshang.ink
 * @Date 2019/9/24 16:04
 */
public class 斐波拉契数列Solution2 {
	int[] memo;
	public int Fibonacci(int n) {
		memo = new int[n + 1];
		Arrays.fill(memo, - 1);
		return dp(n);
	}

	private int dp(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 1;
		}
		if (memo[n] == -1) {
			memo[n] = dp(n - 1) + dp(n - 2);
		}

		return memo[n];
	}
}
