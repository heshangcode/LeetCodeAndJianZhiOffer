package com.hs.JianZhiOffer.树;

import java.util.LinkedList;

/**
 * 输入一棵二叉树的根结点，求该树的深度。
 * <p>
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * <p>
 * 样例
 * 输入：二叉树[8, 12, 2, null, null, 6, 4, null, null, null, null]如下图所示：
 * 8
 * / \
 * 12  2
 * / \
 * 6   4
 * <p>
 * 输出：3
 * <p>
 * 思路：递推
 * 利用层次遍历，每一层计数
 *
 * @Author heshang.ink
 * @Date 2019/10/12 14:39
 */
public class 二叉树的深度Solution2 {
	public int treeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int res = 0;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode pop = queue.pop();
				if (pop.left != null) {
					queue.add(pop.left);
				}
				if (pop.right != null) {
					queue.add(pop.right);
				}
			}
			res++;

		}
		return res;
	}
}
