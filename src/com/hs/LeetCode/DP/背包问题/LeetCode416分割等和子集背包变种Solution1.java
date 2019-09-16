package com.hs.LeetCode.DP.背包问题;

import java.util.Arrays;

/**
 * 背包问题的变种，
 * 思路1：记忆化搜索
 * 思路2：自底向上DP，二维数组
 * 思路3：自底向上DP，一维数组
 *
 * @Author heshang.ink
 * @Date 2019/9/14 17:13
 */
public class LeetCode416分割等和子集背包变种Solution1 {

	// memo[i][c] 表示使用索引为[0...i]的这些元素,是否可以完全填充一个容量为c的背包
	// -1 表示为未计算; 0 表示不可以填充; 1 表示可以填充
	int[][] memo;

	/**
	 * 思路1：记忆化搜索，背包容量就是sum/2，
	 * 只要helper(nums,index - 1,c) || helper(nums,index - 1,c - nums[index]) 为true就行
	 *
	 * @param nums
	 * @return
	 */
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
		memo = new int[n][sum / 2 + 1];
		for (int i = 0; i < n; i++) {
			Arrays.fill(memo[i], -1);
		}
		return helper(nums, n - 1, sum / 2);
	}

	// 使用nums[0...index], 是否可以完全填充一个容量为sum的背包
	private boolean helper(int[] nums, int index, int sum) {
		if (sum == 0) {
			return true;
		}
		if (index < 0 || sum < 0) {
			return false;
		}
		if (memo[index][sum] != -1) {
			return memo[index][sum] == 1;
		}
		memo[index][sum] = (helper(nums, index - 1, sum) || helper(nums, index - 1, sum - nums[index])) ? 1 : 0;
		return memo[index][sum] == 1;
	}

}
