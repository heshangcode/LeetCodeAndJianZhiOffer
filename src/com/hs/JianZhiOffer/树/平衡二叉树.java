package com.hs.JianZhiOffer.树;

/**
 * 输入一棵二叉树的根结点，判断该树是不是平衡二叉树。
 *
 * 如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 * 注意：
 *
 * 规定空树也是一棵平衡二叉树。
 * 样例
 * 输入：二叉树[5,7,11,null,null,12,9,null,null,null,null]如下所示，
 *     5
 *    / \
 *   7  11
 *     /  \
 *    12   9
 *
 * 输出：true
 *
 * @Author heshang.ink
 * @Date 2019/10/12 16:46
 */
public class 平衡二叉树 {
	boolean res = true;
	public boolean isBalanced(TreeNode root) {
		if(root == null) return true;
		depth(root);
		return res;
	}

	public int depth(TreeNode root){
		if(root == null){
			return 0;
		}
		int left = depth(root.left);
		int right = depth(root.right);
		if(Math.abs(left - right) > 1) res = false;
		return Math.max(left,right) + 1;
	}
}
