package com.hs.LeetCode01.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets-ii/
 * 思路：一眼看见重复的数字，想到排序，然后排序进行去重，比78多了一个去重
 *
 * @Author heshang.ink
 * @Date 2019/8/30 21:08
 */
public class LeetCode90子集II {
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		if (nums.length == 0) {
			return res;
		}
		Arrays.sort(nums);
		dfs(nums, 0, new ArrayList<Integer>());
		return res;
	}

	private void dfs(int[] nums, int index, ArrayList<Integer> path) {
		res.add(new ArrayList<>(path));

		if (path.size() == nums.length) {
			return;
		}
		for (int i = index; i < nums.length; i++) {
			if (i > index && nums[i] == nums[i - 1]) {
				continue;
			}
			path.add(nums[i]);
			dfs(nums, i + 1, path);

			path.remove(path.size() - 1);
		}
	}
}
