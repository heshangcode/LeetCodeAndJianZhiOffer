package com.hs.LeetCode01.树;

/**
 * 计算给定二叉树的所有左叶子之和。
 * <p>
 * 示例：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 思路：递归条件，如何判断他是左叶子
 * 因为有个和是每次递归都要变得，可以设置为全局变量
 *
 * @Author heshang.ink
 * @Date 2019/8/18 17:57
 */
public class LeetCode404左叶子之和 {
	int sum = 0;

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		//找到左叶子节点！！！！
		if (root.left != null && root.left.left == null && root.left.right == null) {
			sum += root.left.val;
		}
		sumOfLeftLeaves(root.left);
		sumOfLeftLeaves(root.right);
		return sum;
	}
}
