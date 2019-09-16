package com.hs.LeetCode.DP.背包问题;

/**
 * 背包问题的变种，
 * 思路1：记忆化搜索
 * 思路2：自底向上DP，二维数组
 * 思路3：自底向上DP，一维数组
 *
 * @Author heshang.ink
 * @Date 2019/9/14 17:13
 */
public class LeetCode416分割等和子集背包变种Solution2 {

	public boolean canPartition(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum % 2 == 1) {
			return false;
		}
		int n = nums.length;
		int c = sum / 2;
		boolean[][] dp = new boolean[n][c + 1];

		for (int i = 0; i <= c; i++) {
			dp[0][i] = (nums[0] == i);
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= c; j++) {
				if (j >= nums[i]) {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n - 1][c];
	}
}
