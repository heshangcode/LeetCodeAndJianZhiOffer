package com.hs.LeetCode01.树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 递推
 *
 * @Author heshang.ink
 * @Date 2019/8/16 15:51
 */
public class LeetCode94二叉树的中序遍历Solution2 {
	public List<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		while (!stack.isEmpty() || curr != null) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			res.add(curr.val);
			curr = curr.right;
		}
		return res;
	}

}
