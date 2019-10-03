package com.hs.JianZhiOffer.树;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 *
 * 如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 样例
 * 如下图所示二叉树[1,2,2,3,4,4,3,null,null,null,null,null,null,null,null]为对称二叉树：
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 如下图所示二叉树[1,2,2,null,4,4,3,null,null,null,null,null,null]不是对称二叉树：
 *     1
 *    / \
 *   2   2
 *    \ / \
 *    4 4  3
 *
 * lc:101
 * 思路：找规律，发现：
 * 左子树.right==右子树.left
 * 左子树.left==右子树.right
 *
 * @Author heshang.ink
 * @Date 2019/10/3 9:20
 */
public class 对称的二叉树 {
	boolean isSymmetrical(TreeNode pRoot) {
		if (pRoot == null) {
			return true;
		}
		return dfs(pRoot.left, pRoot.right);
	}

	private boolean dfs(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		return p.val == q.val && dfs(p.right, q.left) && dfs(p.left, q.right);

	}
}
