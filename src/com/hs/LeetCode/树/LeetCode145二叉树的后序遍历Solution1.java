package com.hs.LeetCode.树;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归
 *
 * @Author heshang.ink
 * @Date 2019/8/16 15:51
 */
public class LeetCode145二叉树的后序遍历Solution1 {
	public List<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		postorderTraversal(root, res);
		return res;
	}
	public void postorderTraversal(TreeNode node,List<Integer> list) {
		if (node == null) {
			return;
		}
		postorderTraversal(node.left,list);
		postorderTraversal(node.right,list);
		list.add(node.val);

	}
}
