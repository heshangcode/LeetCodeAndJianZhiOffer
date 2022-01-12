package com.hs.LeetCode01.树;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 思路1：
 * 递归结束条件：
 *
 * 都为空指针则返回 true
 * 只有一个为空则返回 false
 * 递归过程：
 *
 * 判断两个指针当前节点值是否相等
 * 判断 A 的右子树与 B 的左子树是否对称
 * 判断 A 的左子树与 B 的右子树是否对称
 * 短路：
 * 在递归判断过程中存在短路现象，也就是做 与 操作时，如果前面的值返回 false 则后面的不再进行计算
 * 时间复杂度：O(n)O(n)
 * 链接：https://leetcode-cn.com/problems/two-sum/solution/hua-jie-suan-fa-101-dui-cheng-er-cha-shu-by-guanpe/
 * @Author heshang.ink
 * @Date 2019/8/17 20:34
 */
public class LeetCode101对称二叉树 {
	public boolean isSymmetric(TreeNode root) {
		return isMirror(root, root);
	}

	private boolean isMirror(TreeNode root, TreeNode root1) {
		if (root == null && root1 == null) {
			return true;
		}
		if (root == null || root1 == null) {
			return false;
		}
		return (root.val == root1.val) && isMirror(root.left, root1.right) && isMirror(root.right, root1.left);
	}
}
