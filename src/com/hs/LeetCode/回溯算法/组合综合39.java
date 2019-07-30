package com.hs.LeetCode.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author heshang.ink
 * @Date 2019/6/18 8:53
 */
public class 组合综合39 {
	List<List<Integer>> ans = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		/**
		 * 思路，查找和排序.查找.排序，然后枚举每一个数组，
		 */
		if (candidates.length == 0) {
			return ans;
		}
		int sum = 0;
		Arrays.sort(candidates);
		dfs(candidates, target, 0, new ArrayList<>());
		return ans;
	}

	public void dfs(int[] candidates, int target, int s, ArrayList<Integer> path) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			ans.add(new ArrayList<>(path));
			return;
		}
		for (int i = s; i < candidates.length; i++) {
			//这里为了优化，如果后面的数大于target，就不需要继续遍历了
			if (candidates[i] > target) {
				break;
			}
			path.add(candidates[i]);
			dfs(candidates, target - candidates[i], i, path);
			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] args) {
		new 组合综合39().combinationSum(new int[]{2, 3, 6, 7, 8}, 7);
	}
}
