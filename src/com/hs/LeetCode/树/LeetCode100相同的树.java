package com.hs.LeetCode.树;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:      1          1
 * /           \
 * 2             2
 * <p>
 * [1,2],     [1,null,2]
 * <p>
 * 输出: false
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 思路1：递归依次比较呗
 * @Author heshang.ink
 * @Date 2019/8/17 20:21
 */
public class LeetCode100相同的树 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.val != q.val) {
			return false;
		}
		if (isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) {
			return true;
		} else {
			return false;
		}
	}

}
