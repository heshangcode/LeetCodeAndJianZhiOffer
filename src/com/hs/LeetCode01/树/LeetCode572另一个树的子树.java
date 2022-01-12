package com.hs.LeetCode01.树;

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 *
 * 思路：
 * 1.首先寻找根节点相同节点。
 *      先判断根节点是否相等，如果相等，再判断子树是否相等。
 *      否则，判断子树是否等于原树左子树的子树。
 *      否则，判断子树是否等于原树右子树的子树。
 * 2.然后判断子树是否相等
 *      如果都为空，则相等。
 *      如果其中一个不为空，则不等。
 *      如果都不为空，但值不相等，则不等。
 *      递归判断对应左右节点是否相等。
 *
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree/solution/572-ling-yi-ge-shu-de-zi-shu-xian-xu-bian-li
 * -di-gu/
 * @Author heshang.ink
 * @Date 2019/10/3 8:57
 */
public class LeetCode572另一个树的子树 {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null || t == null) {
			return false;
		}
		if (hasSame(s, t)) {
			return true;
		}
		return isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	private boolean hasSame(TreeNode s, TreeNode t) {
		if (t == null && s == null) {
			return true;
		}
		if (s == null || t == null || s.val != t.val) {
			return false;
		}
		return hasSame(s.left, t.left) && hasSame(s.right, t.right);
	}

}
