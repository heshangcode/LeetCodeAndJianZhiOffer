package com.hs.JianZhiOffer;

import java.util.HashSet;

/**
 * 思路1：用set存值，依次遍历比较
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * @Author heshang.ink
 * @Date 2019/9/23 16:01
 */
public class 找出数组中重复的数字Solution1 {
	public boolean duplicate(int numbers[],int length,int [] duplication) {

		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < length; i++) {
			if (set.contains(numbers[i])) {
				duplication[0] = numbers[i];
				return true;
			} else {
				set.add(numbers[i]);
			}
		}
		return false;
	}
}
