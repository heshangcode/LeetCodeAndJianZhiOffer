package com.hs.LeetCode.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * 思路：只是在39题上，加入了条件：一个数字只能用一次，46题也是一个数字只能用一次，40题中数组有重复的数字，
 * 所以需要去重，可以直接在结果集去重
 * 1.//这里必须要来一个去重
 * if (!res.contains(path)) {
 * res.add(new ArrayList<>(path));
 * }
 * 2.也可以在每次遍历数组去重
 * 回溯
 *
 * @Author heshang.ink
 * @Date 2019/8/28 17:39
 */
public class LeetCode40组合总和II {

	List<List<Integer>> res = new ArrayList<>();
	boolean[] used;

	public List<List<Integer>> combinationSum2(int[] nums, int target) {
		if (nums.length == 0) {
			return res;
		}
		used = new boolean[nums.length];
		Arrays.sort(nums);
		dfs(nums, target, 0, new ArrayList<Integer>());
		return res;
	}

	private void dfs(int[] nums, int target, int index, ArrayList<Integer> path) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			//这里必须要来一个去重
			//if (!res.contains(path)) {
				res.add(new ArrayList<>(path));
			//}
			return;

		}
		for (int i = index; i < nums.length; i++) {
			//优化,如果这个数大于target 后面的数肯定也大于了
			if (i != index && nums[i] == nums[i - 1]) {
				continue;
			}
			if (nums[i] > target) {
				break;
			}
			if (!used[i]) {
				used[i] = true;
				path.add(nums[i]);
				// 【关键】因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
				// 跟used作用差不多一样，如果有used，就直接是i
				dfs(nums, target - nums[i], i + 1, path);

				path.remove(path.size() - 1);
				used[i] = false;
			}

		}

	}
}
