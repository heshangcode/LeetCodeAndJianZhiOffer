package com.hs.LeetCode.DP;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 思路1：回溯dfs，超时
 * 思路2：记忆化搜索
 * 思路3：自底向上，DP
 * @Author heshang.ink
 * @Date 2019/9/14 20:26
 */
public class LeetCode377组合总和ⅣSolution1 {
	int res = 0;

	public int combinationSum4(int[] nums, int target) {
		if (nums.length == 0 || target < 0) {
			return res;
		}
		Arrays.sort(nums);
		dfs(nums, target, new ArrayList<Integer>());
		return res;
	}

	private void dfs(int[] nums, int target, ArrayList<Integer> path) {
		if (target == 0) {
			res++;
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (target < nums[i]) {
				continue;
			}
			dfs(nums, target - nums[i], path);
		}
	}
}
