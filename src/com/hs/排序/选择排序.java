package com.hs.排序;

import java.util.Arrays;

/**
 * 先从0-（n-1），选一个最小的放0，然后1-（n-1）选一个最小数放1，依次递减
 *
 * @Author heshang.ink
 * @Date 2019/8/21 17:17
 */
public class 选择排序 {
	public static void main(String[] args) {
		int[] nums = new int[]{2, 8, 13, 11, 6, 7};
		chooseSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	private static void chooseSort(int[] nums) {

		//依次从后面进行选择小的值
		for (int i = 0; i < nums.length; i++) {
			int min = nums[i];
			//从当前这个num[i]后面的数继续比较
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < min) {
					int temp = min;
					min = nums[j];
					nums[j] = temp;
				}
			}
			nums[i] = min;
		}
	}
}
