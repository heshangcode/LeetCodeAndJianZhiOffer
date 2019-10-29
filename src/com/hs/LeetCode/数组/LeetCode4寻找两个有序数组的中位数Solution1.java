package com.hs.LeetCode.数组;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/9/24 10:46
 */
public class LeetCode4寻找两个有序数组的中位数Solution1 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int l1 = nums1.length,l2 = nums2.length;
		int[] nums = new int[l1 + l2];
		int i = 0, j = 0, k = 0;
		//合并两个数组
		while(i < l1 && j < l2){
			if(nums1[i] < nums2[j]){
				nums[k] = nums1[i++];
			}else{
				nums[k] = nums2[j++];
			}
			k++;
		}
		while(i < l1){
			nums[k++] = nums1[i++];
		}
		while(j < l2){
			nums[k++] = nums2[j++];
		}
		if(nums.length % 2 == 0){
			return (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0;
		}else{
			return nums[nums.length / 2];
		}

	}
}
