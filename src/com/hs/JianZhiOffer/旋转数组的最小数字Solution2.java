package com.hs.JianZhiOffer;

/**
 * 思路2：二分思路
 *
 * @Author heshang.ink
 * @Date 2019/9/24 16:02
 */
public class 旋转数组的最小数字Solution2 {
	public static int minNumberInRotateArray(int [] array) {
		if (array.length == 0) {
			return -1;
		}
		//判读如果这个数组没有旋转的话
		int len = array.length - 1;
		if (array[0] < array[len]) {
			return array[0];
		}

		//去掉重复的元素，比如3 4 5 1 2 3 ，3什么就是重复
		while (array[0] == array[len] && len > 0) {
			len--;
		}
		//二分
		int left = 0, right = len;
		while (left < right) {
			int mid = (left + right) / 2;    //[l,mid],[mid + 1,r]
			if (array[mid] < array[0]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return array[left];
	}

	public static void main(String[] args) {
		System.out.println(minNumberInRotateArray(new int[]{3, 4, 5, 1, 2, 3}));
	}
}
