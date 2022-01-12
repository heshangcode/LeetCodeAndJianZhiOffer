package com.hs.LeetCode01.树;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 *  示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * <p>
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 思路：小坑就是需要另外一个方法，记录每次的list
 * @Author heshang.ink
 * @Date 2019/8/16 15:29
 */
public class LeetCode144二叉树的前序遍历Solution1 {
	public List<Integer> preorderTraversal(TreeNode root) {
		if (root == null) {
			return null;
		}
		ArrayList<Integer> res = new ArrayList<>();
		preorderTraversal(root, res);
		return res;
	}

	public void preorderTraversal(TreeNode node, List<Integer> list) {
		if (node == null) {
			return;
		}
		list.add(node.val);
		preorderTraversal(node.left, list);
		preorderTraversal(node.right, list);
	}
}
