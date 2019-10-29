package com.hs.LeetCode.DP;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 *
 * 思路1：类比198
 * 每一次考虑第一个选还是不选的问题
 *
 * @Author heshang.ink
 * @Date 2019/9/8 21:23
 */
public class LeetCode213打家劫舍II {
	public int rob(int[] nums) {
		int len = nums.length;
		if (len == 0) {
			return 0;
		}
		if (len == 1) {
			return nums[0];
		}
		//选第一个
		int[] a = new int[len + 1];
		//不选第一个
		int[] b = new int[len + 1];

		for (int i = 2; i <= len; i++) {
			a[i] = Math.max(a[i - 1], a[i - 2] + nums[i - 2]);
			b[i] = Math.max(b[i - 1], b[i - 2] + nums[i - 1]);
		}
		return Math.max(a[len], b[len]);
	}
}
