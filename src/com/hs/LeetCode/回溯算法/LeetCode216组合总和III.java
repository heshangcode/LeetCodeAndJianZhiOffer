package com.hs.LeetCode.回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-iii/
 * 思路：
 *
 * @Author heshang.ink
 * @Date 2019/8/29 17:33
 */
public class LeetCode216组合总和III {
	//装结果
	List<List<Integer>> res = new ArrayList<>();
	//标识这个数字有没有被使用
	boolean[] used;

	public List<List<Integer>> combinationSum3(int k, int n) {
		if (k == 0 || n == 0) {
			return res;
		}
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		//dfs1(1, n, k, new ArrayList<Integer>());
		dfs1(nums, 0, n, k, new ArrayList<Integer>());
		return res;
	}

	/**
	 * 因为说了1--9的数据，可以用下标进行计算
	 *
	 * @param index
	 * @param target
	 * @param k
	 * @param path
	 */
	private void dfs1(int index, int target, int k, ArrayList<Integer> path) {
		if (target < 0) {
			return;
		}
		if (target == 0 && path.size() == k) {
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i = index; i <= 9; i++) {
			//优化剪枝
			if (i > target) {
				break;
			}
			path.add(i);
			dfs1(i + 1, target - i, k, path);

			path.remove(path.size() - 1);
		}
	}

	/**
	 * 标准组合求数模板，从给定的数组里选数字
	 *
	 * @param nums
	 * @param index
	 * @param target
	 * @param k
	 * @param path
	 */
	private void dfs1(int[] nums, int index, int target, int k, ArrayList<Integer> path) {
		if (target < 0) {
			return;
		}
		if (target == 0 && path.size() == k) {
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i = index; i < nums.length; i++) {
			//优化剪枝
			if (nums[i] > target) {
				break;
			}
			path.add(nums[i]);
			dfs1(nums, i + 1, target - nums[i], k, path);

			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(new LeetCode216组合总和III().combinationSum3(3, 7));
	}

}
