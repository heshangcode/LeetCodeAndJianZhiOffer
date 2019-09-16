package com.hs.LeetCode.DP.背包问题;

import java.util.Arrays;

/**
 * 思路1：回溯dfs，超时
 * 思路2：记忆化搜索
 * 思路3：自底向上，DP
 *
 * @Author heshang.ink
 * @Date 2019/9/14 20:26
 */
public class LeetCode377组合总和Ⅳ完全背包Solution3 {

	public int combinationSum4(int[] nums, int target) {
		if (nums.length == 0 || target < 0) {
			return 0;
		}
		Arrays.sort(nums);
		// 1. 状态 存为target的有多少解
		int[] dp = new int[target + 1];
		// 2. 初始化 关键点，就是构成0的话，就一个解，什么也不做
		dp[0] = 1;
		//依次枚举 每次target 为 i的时候的解
		for (int i = 1; i <= target; i++) {

			for (int j = 0; j < nums.length; j++) {
				if (i < nums[j]) {
					break;
				}
				// 3.转移方程
				dp[i] += dp[i - nums[j]];
			}
		}
		// 4. 返回结果
		return dp[target];
	}

}
