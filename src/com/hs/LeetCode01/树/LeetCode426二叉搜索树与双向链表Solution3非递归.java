package com.hs.LeetCode01.树;

import com.hs.JianZhiOffer.树.TreeNode;

import java.util.Stack;

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
 * <p>
 * AcWing 49. 二叉搜索树与双向链表 - AcWing
 * https://www.acwing.com/activity/content/code/content/120521/
 *
 * @Author heshang.ink
 * @Date 2019/10/5 20:12
 */
public class LeetCode426二叉搜索树与双向链表Solution3非递归 {

	public TreeNode Convert(TreeNode root) {
		if (root == null || root.left == null && root.right == null) {
			return root;
		}
		TreeNode last = null;
		Stack<TreeNode> stack = new Stack<>();

		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				TreeNode cur = root;
				cur.left = last;
				if (last != null) {
					last.right = cur;
				}
				last = cur;
				root = root.right;
			}

		}
		TreeNode node = last;
		while (node != null && node.left != null) {
			node = node.left;
		}
		return node;
	}

}
