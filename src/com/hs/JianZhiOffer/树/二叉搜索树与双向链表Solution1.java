package com.hs.JianZhiOffer.树;

import java.util.ArrayList;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 注意：
 *
 * 需要返回双向链表最左侧的节点。
 * 例如，输入下图中左边的二叉搜索树，则输出右边的排序双向链表。
 *
 * 思路1：中序遍历数放入数组，然后生成双向链表
 *
 * @Author heshang.ink
 * @Date 2019/10/5 20:12
 */
public class 二叉搜索树与双向链表Solution1 {
	public TreeNode Convert(TreeNode root) {
		if (root == null) {
			return root;
		}
		ArrayList<TreeNode> list = new ArrayList<>();

		Convert(root,list);
		return Convert(list);
	}

	/**
	 * 中序遍历
	 * @param root
	 * @param list
	 */
	private void Convert(TreeNode root, ArrayList<TreeNode> list) {
		if (root.left != null) {
			Convert(root.left, list);
		}
		list.add(root);

		if (root.right != null) {
			Convert(root.right, list);
		}
	}
	private TreeNode Convert(ArrayList<TreeNode> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			list.get(i).right = list.get(i + 1);
			list.get(i + 1).left = list.get(i);
		}
		return list.get(0);
	}

}
