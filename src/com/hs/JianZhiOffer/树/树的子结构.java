package com.hs.JianZhiOffer.树;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * <p>
 * 我们规定空树不是任何树的子结构。
 * <p>
 * 样例
 * 树A：
 * <p>
 * 8
 * / \
 * 8   7
 * / \
 * 9   2
 * / \
 * 4   7
 * 树B：
 * <p>
 * 8
 * / \
 * 9   2
 * 返回 true ,因为B是A的子结构。
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
 * @Author heshang.ink
 * @Date 2019/9/30 21:29
 */
public class 树的子结构 {
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null) {
			return false;
		}
		if (hasSame(root1, root2)) {
			return true;
		}
		//左右子树找根
		return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
	}

	/**
	 * 这里就是主要判断以root1为根的树能不能找到
	 * @param root1
	 * @param root2
	 * @return
	 */
	private boolean hasSame(TreeNode root1, TreeNode root2) {
		if (root2 == null) {
			return true;
		}
		if (root1 == null || root1.val != root2.val) {
			return false;
		}
		return hasSame(root1.left, root2.left) && hasSame(root1.right, root2.right);
	}
}
