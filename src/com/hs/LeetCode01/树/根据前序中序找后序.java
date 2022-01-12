package com.hs.LeetCode01.树;

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

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int preLen = preorder.length;
		int inLen = inorder.length;
		if (preLen != inLen) {
			throw new RuntimeException("Incorrect input data.");
		}
		return buildTree(preorder, 0, preLen - 1, inorder, 0, inLen - 1);
	}


	/**
	 * 使用数组 preorder 在索引区间 [preLeft, preRight] 中的所有元素
	 * 和数组 inorder 在索引区间 [inLeft, inRight] 中的所有元素构造二叉树
	 *
	 * @param preorder 二叉树前序遍历结果
	 * @param preLeft  二叉树前序遍历结果的左边界
	 * @param preRight 二叉树前序遍历结果的右边界
	 * @param inorder  二叉树后序遍历结果
	 * @param inLeft   二叉树后序遍历结果的左边界
	 * @param inRight  二叉树后序遍历结果的右边界
	 * @return 二叉树的根结点
	 */
	private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
	                           int[] inorder, int inLeft, int inRight) {
		// 因为是递归调用的方法，按照国际惯例，先写递归终止条件
		if (preLeft > preRight || inLeft > inRight) {
			return null;
		}
		// 先序遍历的起点元素很重要
		int pivot = preorder[preLeft];
		TreeNode root = new TreeNode(pivot);
		int pivotIndex = inLeft;
		// 严格上说还要做数组下标是否越界的判断 pivotIndex < inRight
		while (inorder[pivotIndex] != pivot) {
			pivotIndex++;
		}
		root.left = buildTree(preorder, preLeft + 1, pivotIndex - inLeft + preLeft,
				inorder, inLeft, pivotIndex - 1);
		root.right = buildTree(preorder, pivotIndex - inLeft + preLeft + 1, preRight,
				inorder, pivotIndex + 1, inRight);
		return root;
	}

}
