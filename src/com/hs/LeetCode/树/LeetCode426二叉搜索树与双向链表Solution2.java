package com.hs.LeetCode.树;

import com.hs.JianZhiOffer.树.TreeNode;

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
 * 利用中序遍历，是有序的
 * AcWing 49. 二叉搜索树与双向链表 - AcWing
 * https://www.acwing.com/activity/content/code/content/120521/
 *
 * @Author heshang.ink
 * @Date 2019/10/5 20:12
 */
public class LeetCode426二叉搜索树与双向链表Solution2 {
	//存前一个节点
	TreeNode pre = null;
	//链表的头节点
	TreeNode head = null;

	public TreeNode Convert(TreeNode root) {
		Convert2(root);
		return head;
	}

	private void Convert2(TreeNode root) {
		if (root == null) {
			return;
		}
		//遍历左子树
		Convert2(root.left);
		// root一直为当前要处理的节点
		// 这里left和right，就是左边指向和右边指向
		root.left = pre;
		//找到最左边的节点，head ==null说明一直没有头节点，设置头节点
		if (head == null) {
			head = root;
		}

		// 说明有前节点，就把root当前节点设置为前节点的右节点
		if (pre != null) {
			pre.right = root;
		}
		// 每次把pre更新成当前节点，这样下次就可以使用root.left = pre
		pre = root;

		// 遍历右子树
		Convert2(root.right);
	}

}
