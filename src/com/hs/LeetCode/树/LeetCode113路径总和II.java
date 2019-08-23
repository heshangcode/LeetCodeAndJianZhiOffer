package com.hs.LeetCode.树;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 * 思路：看112，在112的基础要求了把路径放进去
 * 看见返回路径，第一时间想到dfs，路径模板
 * 注意每次加入，要清洁加入的那个元素
 * @Author heshang.ink
 * @Date 2019/8/18 18:54
 */
public class LeetCode113路径总和II {
	List<List<Integer>> ans = new ArrayList<>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		dfs(root, new ArrayList<Integer>(), sum);
		return ans;
	}

	private void dfs(TreeNode root, ArrayList<Integer> path, int sum) {
		if (root == null) {
			return;
		}
		sum -= root.val;
		path.add(root.val);
		if (root.left == null && root.right == null && sum == 0) {
			ans.add(new ArrayList<>(path));
			//每一次清洁加入的那个元素
			path.remove(path.size() - 1);
			return;
		}
		dfs(root.left, path, sum);
		dfs(root.right, path, sum);
		//每一次清洁加入的那个元素
		path.remove(path.size() - 1);
	}
}
