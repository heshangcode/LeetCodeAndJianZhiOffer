package com.hs.LeetCode01.回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * 思路：递归+回溯，但是得注意，你得知道这个值有没有被用，
 * 如果被用，那就不用加，每次回溯结束，需要恢复原状
 *
 * @Author heshang.ink
 * @Date 2019/8/22 8:50
 */
public class LeetCode46全排列 {

	//装结果
	List<List<Integer>> res = new ArrayList<>();
	//标识这个数字有没有被使用
	boolean[] used;

	public List<List<Integer>> permute(int[] nums) {
		if (nums.length == 0) {
			return res;
		}
		used = new boolean[nums.length];
		dfs(nums, 0, new ArrayList<Integer>());
		return res;
	}

	/**
	 * 回溯算法
	 *
	 * @param nums
	 * @param index path中保存了一个有index - 1个元素的排列
	 * @param path  每次回溯排列的元素
	 */
	private void dfs(int[] nums, int index, ArrayList<Integer> path) {
		if (index == nums.length) {
			//必须要用new ArrayList<>(path)
			//不能直接path
			res.add((new ArrayList<>(path)));
			return;
		}

		//枚举数组元素
		for (int i = 0; i < nums.length; i++) {
			//判断这个数有没有被用
			if (!used[i]) {
				//没有被用
				path.add(nums[i]);
				used[i] = true;
				dfs(nums, index + 1, path);

				//恢复原状
				used[i] = false;
				path.remove(path.size() - 1);
			}
		}
		return;
	}
}
