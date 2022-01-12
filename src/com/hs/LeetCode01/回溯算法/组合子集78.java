package com.hs.LeetCode01.回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

 说明：解集不能包含重复的子集。

 示例:

 输入: nums = [1,2,3]
 输出:
 [
 [3],
   [1],
   [2],
   [1,2,3],
   [1,3],
   [2,3],
   [1,2],
   []
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/subsets
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author heshang.ink
 * @Date 2019/6/15 20:20
 */
public class 组合子集78 {
	List<List<Integer>> ans = new ArrayList<>();
	public List<List<Integer>> subsets(int[] nums) {
		for(int i = 0;i <= nums.length; i++){
			dfs(nums,new ArrayList<>(),i,0);
		}
		return ans;
	}
	public void dfs(int[] nums,ArrayList<Integer> path,int n ,int s){
		if(n == path.size()){
			ans.add(new ArrayList<>(path));
			return;
		}
		for(int j = n;j < nums.length;j++){
			path.add(nums[j]);
			dfs(nums,path,n,j + 1);
			path.remove(path.size()-1);
		}
	}

	/**
	 * 也可以这样
	 * @param args
	 */
	/*List<List<Integer>> ans = new ArrayList<>();
	public List<List<Integer>> subsets(int[] nums) {
		if(nums.length == 0){
			return ans;
		}
		//查找和排序.查找.排序
		//Arrays.sort(nums);
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
            //if(i > s && nums[i] == nums[i - 1]) continue;
			path.add(nums[i]);
			dfs(nums,path,i + 1);
			path.remove(path.size() - 1);
		}
	}*/

	public static void main(String[] args) {
		List<List<Integer>> subsets = new 组合子集78().subsets(new int[]{1, 2, 3});
		System.out.println(subsets);
	}

}
