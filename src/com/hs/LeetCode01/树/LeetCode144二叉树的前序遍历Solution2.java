package com.hs.LeetCode01.树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
 * 思路：非递归
 * @Author heshang.ink
 * @Date 2019/8/16 15:29
 */
public class LeetCode144二叉树的前序遍历Solution2 {
	public List<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			root = stack.pop();
			res.add(root.val);
			if (root.right != null) {
				stack.push(root.right);
			}
			if (root.left != null) {
				stack.push(root.left);
			}
		}
		return res;
	}


}
