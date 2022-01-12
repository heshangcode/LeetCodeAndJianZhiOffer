package com.hs.LeetCode01.DP;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/7/3 11:16
 */
public class 最长公共子序列Solution2 {

	public int findLCS(String A, String B) {
		int n = A.length();
		int m = B.length();

		// dp 是 (m + 1) * (n + 1) 的动态规划表格
		// dp[i][j] 表示s1的前i个字符和s2前j个字符的最长公共子序列的长度
		// dp[0][j] 表示s1取空字符串时, 和s2的前j个字符作比较
		// dp[i][0] 表示s2取空字符串时, 和s1的前i个字符作比较
		// 所以, dp[0][j] 和 memo[i][0] 均取0
		// 我们不需要对memo进行单独的边界条件处理 :-)
		int[][] dp = new int[m + 1][n + 1];
		// 动态规划的过程
		// 注意, 由于动态规划状态的转变, 下面的i和j可以取到m和n

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				// 转移方程
				// 两个字符相同
				// dp[i][j] = 1 + dp[i - 1][j - 1];
				// 两个字符不相同
				// 比较i -1和j 或者 i 和j - 1
				// dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[n][m];

	}


}
