package com.hs.LeetCode01.树;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * <p>
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 * @Author heshang.ink
 * @Date 2019/10/27 13:36
 */
public class LeetCode590N叉树的后序遍历 {
	ArrayList<Integer> res = new ArrayList<>();

	public List<Integer> postorder(Node root) {
		helper(root);
		return res;
	}

	private void helper(Node root) {
		if (root == null) {
			return;
		}
		int s = root.children.size();
		for (int i = 0; i < s; i++) {
			helper(root.children.get(i));
		}
		res.add(root.val);
	}
}
