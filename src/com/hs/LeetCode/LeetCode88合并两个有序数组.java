package com.hs.LeetCode;

import java.util.Arrays;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路1：归并排序后的归并算法,时间和空间都是O(n)
 * 思路2: 题中说了nums1长度足够，那就把nums1的数字复制到nums1的后面进行比较 ，时间O(n)，空间O(1)
 *
 * @Author heshang.ink
 * @Date 2019/7/26 20:55
 */
public class LeetCode88合并两个有序数组 {
	public static void merge1(int[] nums1, int m, int[] nums2, int n) {
		if (n == 0) {
			return;
		}
		int[] nums = new int[m + n];
		int i, j, index;
		i = j = index = 0;
		while (i < m && j < n) {
			if (nums1[i] < nums2[j]) {
				nums[index] = nums1[i++];
			} else {
				nums[index] = nums2[j++];
			}
			index++;
			//
		}
		while (i < m) {
			nums[index++] = nums1[i++];
		}
		while (j < n) {
			nums[index++] = nums2[j++];
		}
		for (int k = 0; k < m + n; k++) {
			nums1[k] = nums[k];
		}

	}

	public static void merge2(int[] nums1, int m, int[] nums2, int n) {
		if (nums2.length == 0) {
			return;
		}
		//复制nums1的值到nums1后面
		for (int count = 1; count <= m; count++) {
			nums1[m + n - count] = nums1[m - count];
		}
		int i = n;
		int j = 0;
		int index = 0;
		//遍历nums2
		while (j < n) {
			//如果nums1遍历结束(i == nums.length( m + n))，直接把nums2加入
			if (i == m + n) {
				while (j < n) {
					nums1[index++] = nums2[j++];
				}
				return;
			}
			if (nums1[i] < nums2[j]) {
				nums1[index] = nums1[i++];
			} else {
				nums1[index] = nums2[j++];
			}
			index++;
		}
	}

	public static void merge3(int[] nums1, int m, int[] nums2, int n) {
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
		int[] nums1 = {1, 2, 4, 7, 0, 0, 0};
		int[] nums2 = {2, 5, 6};
		merge2(nums1, 4, nums2, 3);
		System.out.println(Arrays.toString(nums1));
	}
}
