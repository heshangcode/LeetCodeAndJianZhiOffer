package com.hs.JianZhiOffer.DP;

/**
 * 思路2：一维数组dp
 *
 * @Author heshang.ink
 * @Date 2019/9/24 16:04
 */
public class 斐波拉契数列Solution3 {

	public int Fibonacci(int n) {
		if(n == 0) return 0;
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i < n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

}
