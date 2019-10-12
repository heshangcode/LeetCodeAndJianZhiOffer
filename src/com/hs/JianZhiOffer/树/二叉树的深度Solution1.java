package com.hs.JianZhiOffer.树;

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
 * 思路：深度为 ： max(左子树+右子树深度) + 1
 *
 * @Author heshang.ink
 * @Date 2019/10/12 14:39
 */
public class 二叉树的深度Solution1 {
	public int treeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
	}
}
