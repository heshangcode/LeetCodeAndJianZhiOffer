package com.hs.LeetCode.DP.背包问题;

import java.util.Arrays;

/**
 * 思路1：回溯dfs，超时
 * 思路2：记忆化搜索
 * 思路3：自底向上，DP
 * @Author heshang.ink
 * @Date 2019/9/14 20:26
 */
public class LeetCode377组合总和Ⅳ完全背包Solution2 {
	int[] memo;

	public int combinationSum4(int[] nums, int target) {
		if (nums.length == 0 || target < 0) {
			return 0;
		}
		Arrays.sort(nums);
		// 存为target的有多少解
		memo = new int[target + 1];
		//设置为-1，是因为有些解可能就是0，无解
		Arrays.fill(memo, -1);
		//关键点，就是构成0的话，就一个解，什么也不做
		memo[0] = 1;
		helper(nums, target);
		return memo[target];
	}

	private int helper(int[] nums, int target) {

		if (target == 0) {
			return 1;
		}
		int res = 0;    //当前target的组合数
		if (memo[target] != -1) {
			return memo[target];
		}
		for (int i = 0; i < nums.length; i++) {
			//剪枝
			if (target < nums[i]) {
				break;
			}
			res += helper(nums, target - nums[i]);
		}
		memo[target] = res;
		return memo[target];
	}
}
