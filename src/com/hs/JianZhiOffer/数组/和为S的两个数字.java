package com.hs.JianZhiOffer.数组;

import java.util.ArrayList;

/**
 * 输入一个数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * <p>
 * 如果有多对数字的和等于s，输出任意一对即可。
 * <p>
 * 你可以认为每组输入中都至少含有一组满足条件的输出。
 * <p>
 * 样例
 * 输入：[1,2,3,4] , sum=7
 * <p>
 * 输出：[3,4]
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 * <p>
 * <p>
 * 思路：题中说了乘积最小，跟两数之和还是有点差别的，
 * 双指针夹逼法
 *
 * @Author heshang.ink
 * @Date 2019/10/13 9:04
 */
public class 和为S的两个数字 {

	public ArrayList<Integer> FindNumbersWithSum(int[] nums, int target) {
		ArrayList<Integer> list = new ArrayList<>();
		int i = 0, j = nums.length - 1;
		while (i < j) {
			int sum = nums[i] + nums[j];
			if (sum == target) {
				list.add(nums[i]);
				list.add(nums[j]);
			} else if (sum > target) {
				j--;
			} else {
				i++;
			}
		}
		return list;
	}

}
