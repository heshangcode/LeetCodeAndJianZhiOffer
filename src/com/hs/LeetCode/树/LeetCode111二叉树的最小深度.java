package com.hs.LeetCode.树;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/minimum-depth-of-binary-tree-di-gui-jie-fa-by-jin4/
 * https://leetcode.wang/leetcode-111-Minimum-Depth-of-Binary-Tree.html
 * 这道题和maximum depth题正好相反，是求根节点到叶子节点的最小深度，为确保统计的是根节点到叶子节点的深度，需要注意：
 * 当前节点左右子树有一个为空时，返回的应是非空子树的最小深度，而不是空子树深度0；若返回0相当于把当前节点认为成叶子节点，与此节点有非空子树矛盾。
 * 当左右子树都不为空时，和maximum depth题一样，返回左右子树深度的最小值。
 * 当左右子树都为空时，只有1个根节点深度为1（根节点与叶子节点重合）。

 * @Author heshang.ink
 * @Date 2019/8/16 10:50
 */
public class LeetCode111二叉树的最小深度 {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		//如果左子树为空，就需要找右子树的
		if (root.left == null) {
			return minDepth(root.right) + 1;
		}
		//如果右子树为空，就需要找左子树的
		if (root.right == null) {
			return minDepth(root.left) + 1;
		}
		//如果左右子树都有，则比较左右子树最小的
		int leftMinDepth = minDepth(root.left);
		int rightMinDepth = minDepth(root.right);
		return Math.min(leftMinDepth, rightMinDepth) + 1;
	}
}
