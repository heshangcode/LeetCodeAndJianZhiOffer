package com.hs.LeetCode01.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * 思路：跟二叉树层次遍历一样哒
 *
 * @Author heshang.ink
 * @Date 2019/10/27 13:44
 */
public class LeetCode429N叉树的层序遍历 {
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		LinkedList<Node> queue = new LinkedList<>();
		queue.push(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			ArrayList<Integer> list = new ArrayList<>();
			while (size-- > 0) {
				Node pop = queue.pop();
				int childrenSize = pop.children.size();
				for (int i = 0; i < childrenSize; i++) {
					queue.add(pop.children.get(i));
				}
				list.add(pop.val);
			}
			res.add(list);
		}
		return res;
	}
}
