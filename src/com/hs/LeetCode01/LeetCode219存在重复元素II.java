package com.hs.LeetCode01;

import java.util.HashSet;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路：滑动窗口 + 查找表
 *
 * @Author heshang.ink
 * @Date 2019/8/10 11:21
 */
public class LeetCode219存在重复元素II {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if(nums == null || nums.length <= 1) {
			return false;
		}

		if(k <= 0) {
			return false;
		}
		int l = 0, r = -1;  //nums[l...r]是我们的滑动窗口
		//set里存放滑动窗口里的值
		HashSet<Integer> set = new HashSet<>();
		while (l < nums.length) {
			int index = 0;
			//滑动窗口的大小是否在k里
			if (r + 1 < nums.length && r - l + 1 <= k) {
				r++;    //引出条件r + 1 < nums.length
				if (set.contains(nums[r])) {
					return true;
				} else {
					set.add(nums[r]);
				}
			} else {
				//滑动窗口过大了，左边的右移，set去除左边的值
				set.remove(nums[l]);
				l++;
			}
		}
		return false;
	}
}
