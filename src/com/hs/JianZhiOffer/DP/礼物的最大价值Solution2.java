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
 * 思路：最大路径和
 * 1.dp[n][m] 左上角走到n,m这个位置的时候，礼物最大是多少
 * 2.初始化边界条件，可以假设为0，也可以直接
 * 3.转移方程 dp[n][m] = Math.max(dp[n - 1][m],dp[n][m - 1]) + grid[i][j]; 上面/左边礼物最大+当前位置的礼物
 *
 * @Author heshang.ink
 * @Date 2019/10/9 8:54
 */
public class 礼物的最大价值Solution2 {
	public int getMaxValue(int[][] grid) {
		int n = grid.length;
		if (n == 0) {
			return 0;
		}
		int m = grid[0].length;
		// 开n + 1 m +1是因为后面i -1 就不用判断边界条件了
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				//注意是grid[i - 1][j - 1] 不是grid[i][j]
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
			}
		}
		return dp[n][m];
	}
}
