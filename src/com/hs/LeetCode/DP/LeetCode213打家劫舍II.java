package com.hs.LeetCode.DP;

/**
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
