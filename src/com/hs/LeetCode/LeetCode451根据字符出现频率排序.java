package com.hs.LeetCode;

import java.util.Arrays;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/7/31 15:06
 */
public class LeetCode451根据字符出现频率排序 {
	public String frequencySort(String s) {
		int[] nums = new int[256];
		for (int i = 0; i < s.length(); i++) {
			nums[s.charAt(i)]++;
		}
		//主要为了存放数组的下标
		int[] clone = nums.clone();
		Arrays.sort(nums);
		StringBuffer bf = new StringBuffer();
		for (int i = nums.length - 1; i >= 0; i--) {
			for (int j = 0; j < clone.length; j++) {
				if (nums[i] == clone[j]) {
					while (clone[j] > 0) {
						bf.append((char) (j));
						clone[j]--;
					}
				}
			}
		}
		return bf.toString();
	}

	public static void main(String[] args) {
		System.out.println((char) ('e' - 'a' + 'a'));
	}
}
