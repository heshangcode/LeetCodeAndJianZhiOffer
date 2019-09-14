package com.hs.LeetCode.DP;

import com.hs.LeetCode.树.TreeNode;

/**
 * 思路1：树形DP问题
 * https://leetcode-cn.com/problems/house-robber-iii/solution/java-2ms-by-horanol/
 * https://www.youtube.com/watch?v=-i2BFAU25Zk
 * 用一个int[]分别记录包含根节点和不包含根节点时的最大值
 * @Author heshang.ink
 * @Date 2019/9/8 21:40
 */

public class LeetCode337打家劫舍III {

	public int rob(TreeNode root) {
		int[] res = helper(root);
		return Math.max(res[0], res[1]);
	}

	//res[0]为不包括根节点的最大值，res[1]为包括根节点的最大值
	private int[] helper(TreeNode root) {
		int[] res = new int[2];
		if (root == null) {
			return res;
		}
		int[] left = helper(root.left);
		int[] right = helper(root.right);

		//不包含根节点，最大值为两个子树的最大值之和
		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		//包含根节点，最大值为两个子树不包含根节点的最大值加上根节点的值
		res[1] = left[0] + right[0] + root.val;

		return res;
	}
}
