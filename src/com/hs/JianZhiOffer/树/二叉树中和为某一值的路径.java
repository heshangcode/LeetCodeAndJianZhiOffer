package com.hs.JianZhiOffer.树;

import java.util.ArrayList;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * <p>
 * 从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * <p>
 * 样例
 * 给出二叉树如下所示，并给出num=22。
 * 5
 * / \
 * 4   6
 * /   / \
 * 12  13  6
 * /  \    / \
 * 9    1  5   1
 * <p>
 * 输出：[[5,4,12,1],[5,6,6,5]]
 * <p>
 * lc 113 路径总和
 *
 * @Author heshang.ink
 * @Date 2019/10/3 15:09
 */
public class 二叉树中和为某一值的路径 {

	ArrayList<ArrayList<Integer>> res = new ArrayList<>();

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		dfs(root, target, new ArrayList<Integer>());
		return res;
	}

	private void dfs(TreeNode root, int sum, ArrayList<Integer> path) {
		if (root == null) {
			return;
		}
		sum -= root.val;
		path.add(root.val);
		if (root.left == null && root.right == null && sum == 0) {
			res.add(new ArrayList<>(path));

		}
		dfs(root.left, sum, path);
		dfs(root.right, sum, path);
		// 每一次清洁加入的那个元素，这里要不要无所谓
		path.remove(path.size() - 1);
		sum += root.val;
	}
}
