package com.hs.LeetCode.回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/8/29 16:49
 */
public class 回溯模板 {
	//装结果
	List<List<Integer>> res = new ArrayList<>();

	//标识这个数字有没有被使用，也就是数字不能被重复使用
	boolean[] used;

	public List<List<Integer>> huisu(int[] nums) {
		if (nums.length == 0) {
			return res;
		}
		used = new boolean[nums.length];
		dfs(nums, 0, new ArrayList<>());
		return res;
	}

	/**
	 * @param nums  输入的数组
	 * @param index 比如有些取要从当前后面的，不能取前面，组合就需要index
	 * @param path  每一次遍历树的结果
	 */
	public void dfs(int[] nums, int index, ArrayList<Integer> path) {
		//满足条件了，就放入结果集
		if (path.size() == nums.length) {     //这里条件都可能不同，还有一些可能是target == 0
			res.add(new ArrayList<>(path));
			return;
		}
		//依次枚举吧
		for (int i = index; i < nums.length; i++) {     //可能是i = 0
			//执行动作把结果放入path，可能会有一些比如剪枝，去重的操作

			//不能重复就需要判断这个值是否被使用，比如if(!used){}
			if (!used[i]) {
				//可能这个数数在之前的结果集使用过了，所以他不操作，继续下一个，eg47
				if (i > 0 && nums[i] == nums[i - 1] && !used[i]) {
					continue;
				}
				used[i] = true;
				path.add(nums[i]);
				dfs(nums, index, path); //这里可能是index，也可能是index + 1

				//回溯
				used[i] = false;
				path.remove(path.size() - 1);
			}

		}
	}

	/**
	 * 没有index，i直接从0开始，排列就是这样，一般需要配合used使用
	 *
	 * @param nums
	 * @param path
	 */
	public void dfs(int[] nums, ArrayList<Integer> path) {

	}
}
