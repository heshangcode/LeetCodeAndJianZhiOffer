package com.hs.LeetCode01.树;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 *
 * 思路：二叉搜索树的定义，左子树小于根，右子树大于根
 * 乍一看，这是一个平凡的问题。只需要遍历整棵树，检查 node.right.val > node.val 和
 * node.left.val < node.val 对每个结点是否成立。
 * 问题是，这种方法并不总是正确。不仅右子结点要大于该节点，整个右子树的元素都应该大于该节点。
 * 所以每次都需要记录一个上下界
 * @Author heshang.ink
 * @Date 2019/8/18 20:19
 */
public class LeetCode98验证二叉搜索树 {
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isValidBST(root, null, null);
	}

	public boolean isValidBST(TreeNode root, Integer min, Integer max) {
		if (root == null) {
			return true;
		}
		if ((min != null && root.val <= min) ) {
			return false;
		}
		if ((max != null && root.val >= max)) {
			return false;
		}
		return isValidBST(root.left, min, root.val)
				&& isValidBST(root.right, root.val, max);
	}

}
