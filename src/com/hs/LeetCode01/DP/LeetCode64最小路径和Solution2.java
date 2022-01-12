package com.hs.LeetCode01.DP;

/**
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * 思路1：暴力 超时
 * 思路2：二维数组 DP
 * https://www.youtube.com/watch?v=fNlxSd9cGM0&t=346s
 * 1. 状态dp[m][n]
 * 2. 初始化init
 * 3. 找转移公式
 * 4. 结果
 * 思路3：一维数组 空间压缩 DP
 * 1. 状态dp，存每一次的最小解
 * 2. 初始化init
 * 3. 转移公式 dp[i] = grid[i][j] + min(dp[j], dp[j - 1]);
 * 4. 结果
 *
 *
 * @Author heshang.ink
 * @Date 2019/9/5 16:50
 */
public class LeetCode64最小路径和Solution2 {
	public int minPathSum(int[][] grid) {
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


}
