package com.hs.LeetCode.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 * 思路：回溯,题中说的数组无重复数字
 *
 * @Author heshang.ink
 * @Date 2019/8/28 17:39
 */
public class LeetCode39组合总和 {

	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates.length == 0) {
			return res;
		}
		Arrays.sort(candidates);
		dfs(candidates, target, 0, new ArrayList<Integer>());
		return res;
	}

	private void dfs(int[] candidates, int target, int index, ArrayList<Integer> path) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			//优化,如果这个数大于target 后面的数肯定也大于了
			if (candidates[i] > target) {
				break;
			}
			path.add(candidates[i]);
			dfs(candidates, target - candidates[i], i, path);

			path.remove(path.size() - 1);
			target += candidates[i];
		}

	}
}
