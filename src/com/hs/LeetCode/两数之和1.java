package com.hs.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/7/2 15:19
 */
public class 两数之和1 {
	public int[] twoSum(int[] nums, int target) {
		/**
		 * 思路1：两遍哈希表
		 * 思路2：一遍哈希表
		 */
		/*Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { i, map.get(complement) };
			}
		}
		throw new IllegalArgumentException("No two sum solution");*/
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[]{i, map.get(complement)};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}
