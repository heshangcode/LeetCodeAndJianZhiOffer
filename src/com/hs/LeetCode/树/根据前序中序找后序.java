package com.hs.LeetCode.树;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/9/23 19:52
 */
public class 根据前序中序找后序 {
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
	public TreeNode createTree(String preOrder, String inOrder) {
		if (preOrder.isEmpty()) {
			return null;
		}
		char rootValue = preOrder.charAt(0);
		int rootIndex = inOrder.indexOf(rootValue);
		TreeNode root = new TreeNode(rootValue);
		root.left = createTree(preOrder.substring(1, 1 + rootIndex), inOrder.substring(0, rootIndex));
		root.right = createTree(preOrder.substring(1 + rootIndex), inOrder.substring(1 + rootIndex));

		return root;

	}
}
