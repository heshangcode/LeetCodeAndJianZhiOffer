package com.hs.LeetCode01.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 * 思路：46题基础上，思路如何去重，去重思路可以思考给数组排序，
 * 然后比较i > 0 && num[i]==num[i-1]的问题
 * https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
 *
 * @Author heshang.ink
 * @Date 2019/8/22 8:50
 */
public class LeetCode47全排列II {

	//装结果
	List<List<Integer>> res = new ArrayList<>();
	//标识这个数字有没有被使用
	boolean[] used;

	public List<List<Integer>> permuteUnique(int[] nums) {
		if (nums.length == 0) {
			return res;
		}
		// 修改 1：首先排序，之后才有可能发现重复分支
		Arrays.sort(nums);
		used = new boolean[nums.length];
		dfs(nums, new ArrayList<Integer>());
		return res;
	}

	private void dfs(int[] nums, ArrayList<Integer> path) {
		if (path.size() == nums.length) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				// 修改 2：因为排序以后重复的数一定不会出现在开始，故 i > 0
				// 和之前的数相等，并且之前的数还未使用过，只有出现这种情况，才会出现相同分支
				// 这种情况跳过即可
				if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
					continue;
				}
				path.add(nums[i]);
				used[i] = true;
				dfs(nums, path);

				path.remove(path.size() - 1);
				used[i] = false;

			}
		}
	}
}
