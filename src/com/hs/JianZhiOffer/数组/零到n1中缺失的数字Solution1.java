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
 * 1.暴力
 *
 * @Author heshang.ink
 * @Date 2019/10/12 10:41
 */
public class 零到n1中缺失的数字Solution1 {
	public int getMissingNumber(int[] nums) {
		if(nums.length == 0){
			return 0;
		}
		int res = 0;
		for(int i = 0; i < nums.length - 1; i++){
			if(nums[i] != nums[i + 1] - 1){
				res = nums[i] + 1;
			}
		}
		if(nums[nums.length - 1] != nums.length){
			res = nums.length;
		}
		return res;
	}
	//利用等差公式来搞
	public int getMissingNumber2(int[] nums) {
		int n = nums.length + 1;
		int res = (n - 1) * n / 2;
		for (int x : nums) {
			res -= x;
		}
		return res;
	}
}
