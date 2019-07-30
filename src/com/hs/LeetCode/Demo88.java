package com.hs.LeetCode;

import java.util.Arrays;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/7/28 18:50
 */
public class Demo88 {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		//将 nums1 的数字全部移动到末尾
		for (int count = 1; count <= m; count++) {
			nums1[m + n - count] = nums1[m - count];
		}
		int i = n; //i 从 n 开始
		int j = 0;
		int k = 0;
		//遍历 nums2
		while (j < n) {
			//如果 nums1 遍历结束，将 nums2 直接加入
			if (i == m + n) {
				while (j < n) {
					nums1[k++] = nums2[j++];
				}
				return;
			}
			//哪个数小就对应的添加哪个数
			if (nums2[j] < nums1[i]) {
				nums1[k] = nums2[j++];
			} else {
				nums1[k] = nums1[i++];
			}
			k++;
		}
	}

	public static void main(String[] args) {
		int[] nums1 = {1, 2, 5, 7, 0, 0, 0};
		int[] nums2 = {2, 6, 7};
		merge(nums1, 4, nums2, 3);
		System.out.println(Arrays.toString(nums1));
	}

}
