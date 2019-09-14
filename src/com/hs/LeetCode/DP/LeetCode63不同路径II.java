package com.hs.LeetCode.DP;

/**
 * 思路1：跟62差一点的地方在哪，
 * 1. 首先初始化的时候，如果遇见1，说明后面的就不能直接到了，直接break
 * 2. 状态方程，提前去判断是0还是1，如果是1，算下一个，continue
 *
 * @Author heshang.ink
 * @Date 2019/9/8 14:57
 */
public class LeetCode63不同路径II {
	int[][] dp;
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		if (m == 0) {
			return 0;
		}
		int n = obstacleGrid[0].length;
		dp = new int[m][n];
		//2.初始化
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 1) {
				break;
			}
			dp[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {
			if (obstacleGrid[0][j] == 1) {
				break;
			}
			dp[0][j] = 1;
		}
		// 状态方程：dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					continue;
				}
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];

	}
}
