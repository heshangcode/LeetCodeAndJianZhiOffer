package com.hs.LeetCode.回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 * 思路：跟组合和排列问题，就是少了一个递归条件，没有要求必须满足什么
 *
 * @Author heshang.ink
 * @Date 2019/8/29 21:06
 */
public class LeetCode78子集 {
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {
		if (nums.length == 0) {
			return res;
		}
		dfs(nums, 0, new ArrayList<Integer>());

		return res;
	}

	private void dfs(int[] nums, int index, ArrayList<Integer> path) {
		res.add(new ArrayList<>(path));

		if (path.size() == nums.length) {
			return;
		}
		for (int i = index; i < nums.length; i++) {
			path.add(nums[i]);
			dfs(nums, i + 1, path);

			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(new LeetCode78子集().subsets(new int[]{1, 2, 3}));

	}
}
