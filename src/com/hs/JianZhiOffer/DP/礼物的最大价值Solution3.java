package com.hs.JianZhiOffer.DP;

/**
 * 在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。
 *
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格直到到达棋盘的右下角。
 *
 * 给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
 *
 * 注意：
 *
 * m,n>0
 * 样例：
 *
 * 输入：
 * [
 *   [2,3,1],
 *   [1,7,1],
 *   [4,6,1]
 * ]
 *
 * 输出：19
 *
 * 解释：沿着路径 2→3→7→6→1 可以得到拿到最大价值礼物。
 *
 * 思路：最小路径和反例
 * 降低空间复杂度，改用为一维数组
 *
 * @Author heshang.ink
 * @Date 2019/10/9 8:54
 */
public class 礼物的最大价值Solution3 {
	public int getMaxValue(int[][] grid) {
		int n = grid.length;
		if (n == 0) {
			return 0;
		}
		int m = grid[0].length;
		// 表示第i行的   dp[m]表示这一行的第m列的最大值
		int[] dp = new int[m];
		// 初始化，计算第一行的最短路径
		dp[0] = grid[0][0];
		for (int i = 1; i < n; i++) {
			dp[i] = dp[i - 1] + grid[0][i];
		}
		// 转移方程 dp[j] = grid[i][j] + max(dp[j],dp[j - 1])  当前值+前面两列的值
		for (int i = 1; i < n; i++) {
			// 列
			for (int j = 0; j < m; j++) {
				// 处理边界问题，第一列
				if (j == 0) {
					dp[j] += grid[i][j];
				} else {
					dp[j] = grid[i][j] + Math.max(dp[j], dp[j - 1]);
				}
			}
		}
		return dp[m - 1];
	}
}
