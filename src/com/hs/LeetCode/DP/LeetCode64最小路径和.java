package com.hs.LeetCode.DP;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * 思路1：二维数组 DP
 * https://www.youtube.com/watch?v=fNlxSd9cGM0&t=346s
 * 1. 状态dp[m][n]
 * 2. 初始化init
 * 3. 找转移公式
 * 4. 结果
 * 思路2：一维数组 空间压缩 DP
 * 1. 状态dp，存每一次的最小解
 * 2. 初始化init
 * 3. 转移公式 dp[i] = grid[i][j] + min(dp[j], dp[j - 1]);
 * 4. 结果
 * 思路3：暴力 超时
 *
 * @Author heshang.ink
 * @Date 2019/9/5 16:50
 */
public class LeetCode64最小路径和 {
	public int minPathSum1(int[][] grid) {
		int m = grid.length;
		if (m == 0) {
			return 0;
		}
		int n = grid[0].length;
		//1.状态dp[m][n]
		int[][] dp = new int[m][n];
		//2.初始化边界的行和列
		dp[0][0] = grid[0][0];
		//列
		for (int i = 1; i < m; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}
		//行
		for (int j = 1; j < n; j++) {
			dp[0][j] = dp[0][j - 1] + grid[0][j];
		}
		// 3. dp[i][j] = min(dp[i-1][j],dp[i][j-1]) + grid[i][j]
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}
		//4.
		return dp[m - 1][n - 1];
	}

	public int minPathSum2(int[][] grid) {
		int m = grid.length;
		if (m == 0) {
			return 0;
		}
		int n = grid[0].length;
		//1.状态dp，存每一次的最小解
		int[] dp = new int[n];  //其实也可以n + 1，这样的话后面就不需要从1开始
		//2. 初始化 计算第一行的最短路径
		dp[0] = grid[0][0];
		for (int i = 1; i < n; i++) {
			dp[i] = dp[i - 1] + grid[0][i];
		}
		//3. 转移公式 dp[i] = grid[i][j] + min(dp[j], dp[j - 1]);
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				//处理边界问题
				if (j == 0) {
					dp[j] += grid[i][j];
				} else {
					dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);

				}
			}

		}
		return dp[n - 1];

	}

	public int minPathSum3(int[][] grid) {
		return calculate(grid, 0, 0);
	}

	private int calculate(int[][] grid, int i, int j) {
		if (i == grid.length || j == grid[0].length) {
			return Integer.MAX_VALUE;
		}
		if (i == grid.length - 1 && j == grid[0].length - 1) {
			return grid[i][j];
		}
		return grid[i][j] + Math.min(calculate(grid, i + 1, j), calculate(grid, i, j + 1));
	}
}
