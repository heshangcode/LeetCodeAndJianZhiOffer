package com.hs.LeetCode;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/5/1 17:28
 */
public class 两数之和 {
	public static void main(String[] args) {

	}

	public int[] twoSum(int[] nums, int target) {
		int[] sum = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					sum[0] = i;
					sum[1] = j;
				}
			}
		}
		return sum;
	}
}
