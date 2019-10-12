package com.hs.JianZhiOffer.数组;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0到n-1之内。
 *
 * 在范围0到n-1的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 样例
 * 输入：[0,1,2,4]
 *
 * 输出：3
 *
 * 2.二分，用下标和它的值比较，如果num[i] = i，说明位置是正确的，可以二分判断
 * 首先中间如果num[i] = i，说明i前面的数是对的，那不对的数就在后面，反之就在前面
 *
 * @Author heshang.ink
 * @Date 2019/10/12 10:41
 */
public class 零到n1中缺失的数字Solution2 {
	public int getMissingNumber(int[] nums) {
		if(nums.length == 0){
			return 0;
		}
		int res = 0;
		int l = 0, r = nums.length;
		while (l < r) {
			int mid = l + r >> 1;
			if (nums[mid] == mid) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		return l;

	}
}
