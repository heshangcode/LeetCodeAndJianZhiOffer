package com.hs.JianZhiOffer.数组;

/**
 * 输入一个 非空 整型数组，数组里的数可能为正，也可能为负。
 *
 * 数组中一个或连续的多个整数组成一个子数组。
 *
 * 求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 * 样例
 * 输入：[1, -2, 3, 10, -4, 7, 2, -5]
 *
 * 输出：18
 *
 * @Author heshang.ink
 * @Date 2019/10/6 11:33
 */
public class 连续子数组的最大和 {
	public int FindGreatestSumOfSubArray(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		int res = array[0];
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			if (sum < 0) {
				sum = array[i];
			} else {
				sum += array[i];
			}
			res = Math.max(res, sum);
		}
		return res;
	}
}
