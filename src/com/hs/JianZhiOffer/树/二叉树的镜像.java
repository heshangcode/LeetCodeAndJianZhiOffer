package com.hs.JianZhiOffer.树;

/**
 * 输入一个二叉树，将它变换为它的镜像。
 *
 * 样例
 * 输入树：
 *       8
 *      / \
 *     6  10
 *    / \ / \
 *   5  7 9 11
 *
 *  [8,6,10,5,7,9,11,null,null,null,null,null,null,null,null]
 * 输出树：
 *       8
 *      / \
 *     10  6
 *    / \ / \
 *   11 9 7  5
 *
 *  [8,10,6,11,9,7,5,null,null,null,null,null,null,null,null]
 *
 *  lc226 翻转二叉树
 *
 * @Author heshang.ink
 * @Date 2019/10/3 9:14
 */
public class 二叉树的镜像 {
	public void Mirror(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode left = root.left;
		TreeNode right = root.right;
		root.left = right;
		root.right = left;
		Mirror(root.left);
		Mirror(root.right);

	}
}
