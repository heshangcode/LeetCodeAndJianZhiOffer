package com.hs.LeetCode.DP;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 *
 * 思路2：https://www.youtube.com/watch?v=EcJ0wBBMoKA
 * 一个非常清晰的解法
 *
 * https://www.youtube.com/watch?v=7J5rs56JBs8
 * @Author heshang.ink
 * @Date 2019/9/28 11:08
 */
public class LeetCode53最大子序和Solution2 {
	// nums:[-2,1,-3,4,-1,2,1,-5,4]
	// dp:  [-2,1,-2,4,3,5,6,1,5]
	public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
			res = Math.max(res, dp[i]);
		}
		return res;
	}
}
