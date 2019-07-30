package com.hs.LeetCode.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/6/18 9:05
 */
public class 组合综合240 {
	List<List<Integer>> ans = new ArrayList<>();
	boolean[] isUsed;
	public List<List<Integer>> combinationSum2(int[] nums, int target) {
		if (nums.length == 0) {
			return ans;
		}
		Arrays.sort(nums);
		isUsed = new boolean[nums.length];
		dfs(nums,target,new ArrayList<>(),0);
		return ans;
	}
	public void dfs(int[] nums, int target, ArrayList<Integer> path,int s){
		if(target < 0){
			return;
		}
		if(target == 0){
			//去重
			if(!ans.contains(path)){
				ans.add(new ArrayList<>(path));
			}
			return;
		}
		for(int i = s; i< nums.length; i++){
			//这里为了优化，如果后面的数大于target，就不需要继续遍历了
			if (nums[i] > target) {
				break;
			}
			if(!isUsed[i]){
				path.add(nums[i]);
				isUsed[i] = true;
				dfs(nums, target- nums[i], path, i);
				isUsed[i] = false;
				path.remove(path.size() - 1);
			}

		}
	}
}
