package com.hs.LeetCode01.树;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 思路：我们就求高度！就能够得到这题的答案！
 * 设置一个全局变量代表结果是否为平衡二叉树。
 * 对于每一个节点，当求出它左右子树高度的时候。
 * 把左右子树高度差和1进行比较，若此时大于1，那么将全局变量设为false。
 * 最后返回全局变量即可。
 * 链接：https://leetcode-cn.com/problems/two-sum/solution/yi-bian-sao-miao-pan-duan-shi-fou-wei-ping-heng-er/
 * 
 * @Author heshang.ink
 * @Date 2019/8/17 16:02
 */
public class LeetCode110平衡二叉树 {
	boolean ans = true;
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return ans;
		}
		depth(root);
		return ans;
	}

	private int depth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = depth(node.left);
		int right = depth(node.right);
		if (Math.abs(left - right) > 1) {
			ans = false;
		}
		return 1 + Math.max(left, right);
	}
}
