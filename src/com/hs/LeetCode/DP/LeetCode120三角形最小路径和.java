package com.hs.LeetCode.DP;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/triangle/solution/
 * 思路1：递归，自顶向下、超时
 * https://leetcode-cn.com/problems/triangle/solution/di-gui-ji-yi-hua-sou-suo-zai-dao-dp-by-crsm/
 * 思路2：自顶向下，记忆化搜索
 * 思路3：自顶向上，DP
 *
 * @Author heshang.ink
 * @Date 2019/9/3 21:22
 */
public class LeetCode120三角形最小路径和 {
	int row;
	Integer[][] memo;

	public int minimumTotal(List<List<Integer>> triangle) {
		row = triangle.size();
		memo = new Integer[row][row];
		return helper2(0, 0, triangle);
	}

	/**
	 * 自顶向下，记忆化搜索 memo[row][row] 记录这一层+上几层的具体值
	 *
	 * @param level    第几层
	 * @param c        第几个数
	 * @param triangle
	 * @return
	 */
	private int helper2(int level, int c, List<List<Integer>> triangle) {
		if (memo[level][c] != null) {
			return memo[level][c];
		}
		//最后一行到底部的距离就等于它自身的值
		if (level == row - 1) {
			return memo[level][c] = triangle.get(level).get(c);
		}
		int left = helper2(level + 1, c, triangle);
		int right = helper2(level + 1, c + 1, triangle);
		return memo[level][c] = Math.min(left, right) + triangle.get(level).get(c);

	}

	/**
	 * 空间优化： 每次计算一层(i,j)位置的数到底部的最小距离和时，当前层只跟它的下一层有关系，所以我们只用保留下一层的结果
	 * 就可以，用一维数组，一直更新这个一维数组就可以
	 *
	 * @param triangle
	 * @return
	 */
	public int minimumTotal3(List<List<Integer>> triangle) {
		int row = triangle.size();

		int[] dp = new int[row + 1];
		for (int level = row - 1; level >= 0; level--) {
			for (int i = 0; i <= level; i++) {  //第i行有i+1个数字
				dp[i] = Math.min(dp[i], dp[i + 1] + triangle.get(level).get(i));

			}
		}
		return dp[0];
	}

}
