package com.hs.JianZhiOffer;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序。
 * <p>
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分。
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * <p>
 * 样例
 * 输入：[1,2,3,4,5]
 * <p>
 * 输出: [1,3,5,2,4]
 *
 * @Author heshang.ink
 * @Date 2019/9/28 21:23
 */
public class 调整数组顺序使奇数位于偶数前面 {
	public static void reOrderArray(int[] array) {
		int[] ou = new int[array.length];
		int[] ji = new int[array.length];
		int i = 0;
		int j = 0;
		for (int k = 0; k < array.length; k++) {
			if (array[k] % 2 == 0) {
				ou[i++] = array[k];
			} else {
				ji[j++] = array[k];
			}
		}
		for (int k = 0; k < i; k++) {
			ji[j++] = ou[k];
		}
		for (int k = 0; k < j; k++) {
			array[k] = ji[k];
		}

	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5};
		reOrderArray(nums);
		System.out.println(Arrays.toString(nums));
	}
}
