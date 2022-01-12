package com.hs.LeetCode01.DP;

import java.util.Arrays;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 *
 * @Author heshang.ink
 * @Date 2019/9/16 12:33
 */
public class LeetCode300最长上升子序列 {
	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		// dp[i] 表示以 dp[i] 为结尾的最长上升子序列的长度
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], 1 + dp[j]);
				}
			}
		}
		int res = 1;
		for (int i = 0; i < nums.length; i++) {
			res = Math.max(res, dp[i]);
		}
		return res;
	}
}
