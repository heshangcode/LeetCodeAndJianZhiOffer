package com.hs.JianZhiOffer.数组;

/**
 * 假设一个单调递增的数组里的每个元素都是整数并且是唯一的。
 *
 * 请编程实现一个函数找出数组中任意一个数值等于其下标的元素。
 *
 * 例如，在数组[-3, -1, 1, 3, 5]中，数字3和它的下标相等。
 *
 * 样例
 * 输入：[-3, -1, 1, 3, 5]
 *
 * 输出：3
 * 注意:如果不存在，则返回-1。
 * 1.暴力
 * 2.二分 下标和值相等，return，下标大于值，结果肯定在右边，反之在左边
 *
 * @Author heshang.ink
 * @Date 2019/10/12 11:03
 */
public class 数组中数值和下标相等的元素 {
	public int getNumberSameAsIndex(int[] nums) {
		if(nums.length == 0){
			return -1;
		}
		int l = 0,r = nums.length - 1;
		while(l <= r){
			int mid = l + r >> 1;
			if(nums[mid] == mid){
				return mid;
			}else if(nums[mid] < mid){
				l = mid + 1;
			}else {
				r = mid - 1;
			}
		}
		return -1;
	}

	public int getNumberSameAsIndex2(int[] nums) {
		if(nums.length == 0){
			return -1;
		}
		int l = 0,r = nums.length - 1;
		while(l < r){
			int mid = l + r >> 1;
			if (nums[mid] >= mid) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		if (nums[r] == r) {
			return r;
		} else {
			return -1;
		}

	}
}
