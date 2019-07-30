package com.hs.LeetCode.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

 说明：解集不能包含重复的子集。

 示例:

 输入: [1,2,2]
 输出:
 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/subsets-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author heshang.ink
 * @Date 2019/6/17 22:00
 */
public class 组合子集290 {
	List<List<Integer>> ans = new ArrayList<>();
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		if(nums.length == 0){
			return ans;
		}
		Arrays.sort(nums);
		dfs(nums,new ArrayList<>(),0);
		return ans;
	}
	public void dfs(int[] nums,ArrayList<Integer> path,int s){
		ans.add(new ArrayList<>(path));
		if(nums.length == path.size()){
			return;
		}
		for(int i = s;i<nums.length;i++){
			//去重
			if(i > s && nums[i] == nums[i - 1]) continue;
			path.add(nums[i]);
			dfs(nums,path,i + 1);
			path.remove(path.size() - 1);
		}
	}
}
