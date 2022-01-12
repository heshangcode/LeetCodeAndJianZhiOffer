package com.hs.LeetCode01.树;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 * @Author heshang.ink
 * @Date 2019/10/27 13:41
 */
public class LeetCode589N叉树的前序遍历 {
	ArrayList<Integer> res = new ArrayList<>();
	public List<Integer> preorder(Node root) {
		helper(root);
		return res;
	}

	private void helper(Node root) {
		if (root == null) {
			return;
		}
		res.add(root.val);
		int size = root.children.size();
		for (int i = 0; i < size; i++) {
			helper(root.children.get(i));
		}
	}
}
