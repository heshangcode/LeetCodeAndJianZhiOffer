package com.hs.LeetCode01.树;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 *
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 *
 * 思路1：中序遍历就是一个有序的
 * @Author heshang.ink
 * @Date 2019/10/27 14:06
 */
public class LeetCode230二叉搜索树中第K小的元素 {
//	ArrayList<Integer> res = new ArrayList<>();
	int k = 0;
	int res = 0;
	public int kthSmallest(TreeNode root, int k) {
		this.k = k;
		helper(root);
		return res;
	}

	private void helper(TreeNode root) {
		if (root == null) {
			return;
		}
		helper(root.left);
		k--;
		if ( k == 0) {
			res = root.val;
		}
		helper(root.right);
	}
}
