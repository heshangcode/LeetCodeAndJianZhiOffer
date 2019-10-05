package com.hs.JianZhiOffer.树;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * <p>
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * <p>
 * 注意：
 * <p>
 * 需要返回双向链表最左侧的节点。
 * 例如，输入下图中左边的二叉搜索树，则输出右边的排序双向链表。
 * <p>
 * 思路2：不改变存储方式
 *
 * AcWing 49. 二叉搜索树与双向链表 - AcWing
 * https://www.acwing.com/activity/content/code/content/120521/
 *
 * @Author heshang.ink
 * @Date 2019/10/5 20:12
 */
public class 二叉搜索树与双向链表Solution2 {
	TreeNode pre = null;
	TreeNode head = null;

	public TreeNode Convert(TreeNode root) {
		Convert2(root);
		return head;
	}

	private void Convert2(TreeNode root) {
		if (root == null) {
			return;
		}
		Convert2(root.left);
		root.left = pre;
		if (head == null) {
			head = root;
		}
		if (pre != null) {
			pre.right = root;
		}
		pre = root;
		Convert2(root.right);
	}

}
