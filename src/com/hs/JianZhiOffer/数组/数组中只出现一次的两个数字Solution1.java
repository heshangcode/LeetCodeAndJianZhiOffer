package com.hs.JianZhiOffer.数组;

import java.util.Arrays;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 *
 * 请写程序找出这两个只出现一次的数字。
 *
 * 你可以假设这两个数字一定存在。
 *
 * 样例
 * 输入：[1,2,3,3,4,4]
 *
 * 输出：[1,2]
 * 1.暴力
 * @Author heshang.ink
 * @Date 2019/10/12 16:58
 */
public class 数组中只出现一次的两个数字Solution1 {
	public int[] findNumsAppearOnce(int[] nums) {
		int[] res = new int[2];
		int index = 0;
		Arrays.sort(nums);
		for(int i = 0;i < nums.length; ){
			if(i + 1 < nums.length && nums[i] == nums[i+1] ){
				i = i + 2;
			}else{
				res[index++] = nums[i];
				i++;
			}
		}
		return res;

	}
}
