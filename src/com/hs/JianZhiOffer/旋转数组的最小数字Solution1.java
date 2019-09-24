package com.hs.JianZhiOffer;

/**
 * 思路1：常规思路进行比较
 *
 * @Author heshang.ink
 * @Date 2019/9/24 16:02
 */
public class 旋转数组的最小数字Solution1 {
	public int minNumberInRotateArray(int [] array) {
		if (array.length == 0) {
			return -1;
		}
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				return array[i + 1];
			}
		}
		return array[0];

	}
}
