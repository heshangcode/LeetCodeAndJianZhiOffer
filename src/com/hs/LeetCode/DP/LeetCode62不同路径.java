package com.hs.LeetCode.DP;

/**
 * 思路1：
 * 1. 状态变量dp[m][n]
 * 2. init  第一行和第一列，要走到就只有一种方法
 * 3. 状态方程 [i][j] = [i - 1][j]+[i][j - 1]
 * 4. 结果
 * @Author heshang.ink
 * @Date 2019/9/8 13:47
 */
public class LeetCode62不同路径 {
	int[][] dp;

	/**
	 * 思路1
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths(int m, int n) {
		dp = new int[m][n];
		//2. init  第一行和第一列，要走到就只有一种方法
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}
		// 3.[i,j]这个位置就相当于 走上面的+走左边的 转移方程 [i][j] = [i - 1][j]+[i][j - 1]
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] +  dp[i][j - 1] ;
			}
		}
		return dp[m - 1][n - 1];
	}
}
