package com.hs.LeetCode.树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 递推，有一个last节点，记录右子树是否被访问过，整体思路和中序遍历比较像，先一直往左走，不断入栈，再判断最后一个节点，是否有右子树，或者右子树是否已经被访问过
 *
 * @Author heshang.ink
 * @Date 2019/8/16 15:51
 */
public class LeetCode145二叉树的后序遍历Solution3 {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		TreeNode last = null;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.peek();
			if (cur.right == null || cur.right == last) {
				res.add(cur.val);
				stack.pop();
				last = cur;
				cur = null;
			} else {
				cur = cur.right;
			}
		}
		return res;
	}

}
