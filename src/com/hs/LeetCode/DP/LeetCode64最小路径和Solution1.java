package com.hs.LeetCode.DP;

/**
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
 *
 * @Author heshang.ink
 * @Date 2019/9/5 16:50
 */
public class LeetCode64最小路径和Solution1 {

	public int minPathSum(int[][] grid) {
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
