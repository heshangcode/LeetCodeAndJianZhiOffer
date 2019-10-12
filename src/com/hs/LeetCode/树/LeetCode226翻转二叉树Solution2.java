package com.hs.LeetCode.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 思路：递推
 *
 * @Author heshang.ink
 * @Date 2019/8/17 20:18
 */
public class LeetCode226翻转二叉树Solution2 {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode poll = queue.poll();
			TreeNode temp = poll.left;
			poll.left = poll.right;
			poll.right = temp;

			if (poll.left != null) queue.offer(poll.left);
			if (poll.right != null) queue.offer(poll.right);
		}
		return root;
	}
}
