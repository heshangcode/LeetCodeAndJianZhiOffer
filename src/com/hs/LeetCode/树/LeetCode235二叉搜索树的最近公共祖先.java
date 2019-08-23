package com.hs.LeetCode.树;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 思路：二叉搜索树特性，比他小的在左，大的在右
 * p和q就三种情况
 * 1.pq在根左边
 * 2.pq在根右边
 * 3.p或者q为根，另外一个在另外一边,贼两者公共祖先为root
 * @Author heshang.ink
 * @Date 2019/8/18 20:07
 */
public class LeetCode235二叉搜索树的最近公共祖先 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		//pq在根左边
		if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		}
		//pq在根右边
		if (p.val > root.val && q.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		}
		///第三种
		return root;
	}
}
