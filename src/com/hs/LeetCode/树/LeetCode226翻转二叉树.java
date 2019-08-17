package com.hs.LeetCode.树;

/**
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 思路：这个节点的左右子树互换
 * @Author heshang.ink
 * @Date 2019/8/17 20:18
 */
public class LeetCode226翻转二叉树 {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		root.right = left;
		root.left = right;
		return root;
	}
}
