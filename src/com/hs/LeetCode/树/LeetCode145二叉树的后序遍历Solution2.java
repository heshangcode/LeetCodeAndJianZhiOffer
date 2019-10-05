package com.hs.LeetCode.树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 递推，前序遍历是根左右，后序是左右根，可以改写为根右左，然后反转成左右根
 *
 * @Author heshang.ink
 * @Date 2019/8/16 15:51
 */
public class LeetCode145二叉树的后序遍历Solution2 {
	public List<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			res.add(node.val);
			if (node.left != null) {
				stack.push(node.left);
			}
			if (node.right != null) {
				stack.push(node.right);
			}

		}
		Collections.reverse(res);
		return res;
	}

	public List<Integer> postorderTraversal2(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(root);
		while (!s1.isEmpty()) {
			root = s1.pop();
			s2.push(root);
			if (root.left != null) {
				s1.push(root.left);
			}
			if (root.right != null) {
				s1.push(root.right);
			}
		}
		while (!s2.isEmpty()) {
			res.add(s2.pop().val);
		}
		return res;
	}
}
