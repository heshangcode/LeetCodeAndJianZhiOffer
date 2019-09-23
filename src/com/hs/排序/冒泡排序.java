package com.hs.排序;

import java.util.Arrays;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/8/21 17:00
 */
public class 冒泡排序 {
	public static void main(String[] args) {
		int[] nums = new int[]{2, 8, 13, 11, 6, 7};
		bubbleSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void bubbleSort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
		}
	}
}
