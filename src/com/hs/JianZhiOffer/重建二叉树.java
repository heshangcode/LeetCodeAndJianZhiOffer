package com.hs.JianZhiOffer;

import java.util.Arrays;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/9/23 20:05
 */
public class 重建二叉树 {
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre.length == 0 || in.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(pre[0]);
		for (int i = 0; i < in.length; i++) {
			// 在中序中找到前序的根
			if (pre[0] == in[i]) {
				// 左子树，注意 copyOfRange 函数，左闭右开
				root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, 1 + i), Arrays.copyOfRange(in, 0, i));
				// 右子树，注意 copyOfRange 函数，左闭右开
				root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, 1 + i, pre.length), Arrays.copyOfRange(in,
						1 + i, in.length));
			}
		}
		return root;
	}

	/**
	 * 根据前序中序找后序
	 * 思路：
	 * 前：ABDEGCF
	 * 中：DBGEACF
	 * 前的第一个A在中，DBGEA就是左子树
	 *
	 * @param preOrder
	 * @param inOrder
	 * @return
	 */
	public com.hs.LeetCode.树.TreeNode createTree(String preOrder, String inOrder) {
		if (preOrder.isEmpty()) {
			return null;
		}
		char rootValue = preOrder.charAt(0);
		int rootIndex = inOrder.indexOf(rootValue);
		com.hs.LeetCode.树.TreeNode root = new com.hs.LeetCode.树.TreeNode(rootValue);
		root.left = createTree(preOrder.substring(1, 1 + rootIndex), inOrder.substring(0, rootIndex));
		root.right = createTree(preOrder.substring(1 + rootIndex), inOrder.substring(1 + rootIndex));

		return root;

	}
}
