package com.hs.LeetCode.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
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
