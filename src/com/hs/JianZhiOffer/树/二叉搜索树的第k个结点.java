package com.hs.JianZhiOffer.树;

import java.util.ArrayList;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * <p>
 * 你可以假设树和k都存在，并且1≤k≤树的总结点数。
 * <p>
 * 样例
 * 输入：root = [2, 1, 3, null, null, null, null] ，k = 3
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * 输出：3
 * <p>
 * 思路：二叉搜索树的中序遍历就是一个有序的
 *
 * @Author heshang.ink
 * @Date 2019/10/12 14:19
 */
public class 二叉搜索树的第k个结点 {
	ArrayList<TreeNode> res = new ArrayList<>();

	public TreeNode kthNode(TreeNode root, int k) {
		inorderTraversal(root);
		return res.get(k - 1);
	}

	public void inorderTraversal(TreeNode root) {
		if (root == null) return;
		inorderTraversal(root.left);
		res.add(root);
		inorderTraversal(root.right);
	}

	TreeNode ans = null;
	int k;
	public TreeNode kthNode2(TreeNode root, int k) {
		this.k = k;
		dfs(root);
		return ans;
	}

	public void dfs(TreeNode root) {

		if (root == null) return;
		dfs(root.left);
		k--;
		if (k == 0) {
			ans = root;
		}
		dfs(root.right);
	}

}
