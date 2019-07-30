package com.hs.LeetCode.回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author heshang.ink
 * @Date 2019/6/12 8:01
 */
public class 全排列46 {
	//存结果
	List<List<Integer>> res = new ArrayList<>();
	//存这个值是否被使用,0未用,1用
	int[] visited;

	public List<List<Integer>> permute(int[] nums) {
		/**
		 * 思路1：我们从前往后，一位一位枚举，每次选择一个没有被使用过的数。
		 * 选好之后，将该数的状态改成“已被使用”，同时将该数记录在相应位置上，然后递归。
		 * 递归返回时，不要忘记将该数的状态改成“未被使用”，并将该数从相应位置上删除。
		 * 思路2：每次第一个值固定了，把2,3值进行swap
		 */
		//
		if (nums.length == 0) {
			return res;
		}
		visited = new int[nums.length];
		dfs(nums, new ArrayList<Integer>());
		return res;
	}

	public void dfs(int[] nums, ArrayList<Integer> path) {
		//当每个数枚举完了，递归结束
		if (path.size() == nums.length) {
			res.add((new ArrayList<>(path)));
			return;
		}
		//依次枚举每一个数
		for (int i = 0; i < nums.length; i++) {
			//这个枚举值没有被使用
			if (visited[i] == 0) {
				//标识用过了
				visited[i] = 1;
				path.add(nums[i]);
				dfs(nums, path);
				//回溯，需要恢复现场
				visited[i] = 0;
				//插入方案的最后一个数删除
				path.remove(path.size() - 1);

			}
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> permute = new 全排列46().permute(new int[]{1, 2, 3});
		System.out.println(permute);
	}
}
