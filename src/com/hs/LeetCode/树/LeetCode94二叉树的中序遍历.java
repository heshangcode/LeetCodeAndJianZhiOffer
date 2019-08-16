package com.hs.LeetCode.树;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/8/16 15:51
 */
public class LeetCode94二叉树的中序遍历 {
	public List<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		inorderTraversal(root, res);
		return res;
	}
	public void inorderTraversal(TreeNode node,List<Integer> list) {
		if (node == null) {
			return;
		}
		inorderTraversal(node.left,list);
		list.add(node.val);
		inorderTraversal(node.right,list);
	}
}
