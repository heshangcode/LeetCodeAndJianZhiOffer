package com.hs.LeetCode01;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路：3数之和 + 对撞指针 + 绝对值比较
 *
 * @Author heshang.ink
 * @Date 2019/8/1 16:34
 */
public class LeetCode16最接近的三数之和 {
	public static int threeSumClosest(int[] nums, int target) {
		if (nums.length < 3) {
			return -1;
		}
		int res = nums[0] + nums[1] + nums[2];
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int l = i + 1, r = nums.length - 1;
			while (l < r) {
				int sum = nums[i] + nums[l] + nums[r];
				//比较谁离target近，abs取绝对值
				if (Math.abs(sum - target) < Math.abs(res - target)) {
					res = sum;
				}
				if (sum > target) {
					r--;
				} else if (sum < target) {
					l++;
				} else {
					return res;
				}

			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
	}
}
