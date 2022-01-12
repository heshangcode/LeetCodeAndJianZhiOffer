package com.hs.LeetCode01;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例: 
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 * <p>
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路1：暴力法遍历,时间O(n^3)，空间O(1)，超时
 * 思路2：用一个数组求出各个区间的和
 * 思路3：滑动窗口思路
 *
 * @Author heshang.ink
 * @Date 2019/7/30 10:47
 */
public class LeetCode209长度最小的子数组 {
	public static int minSubArrayLen1(int s, int[] nums) {
		if (s <= 0 || nums == null) {
			throw new IllegalArgumentException("Illigal Arguments");
		}

		int res = nums.length + 1;
		for (int l = 0; l < nums.length; l++) {
			for (int r = l; r < nums.length; r++) {
				int sum = 0;
				for (int i = l; i <= r; i++) {
					sum += nums[i];
				}
				if (sum >= s) {
					res = Math.min(res, r - l + 1);
				}
			}
		}

		if (res == nums.length + 1) {
			return 0;
		}

		return res;
	}

	public static int minSubArrayLen2(int s, int[] nums) {
		if (s <= 0 || nums == null) {
			throw new IllegalArgumentException("Illigal Arguments");
		}

		// sums[i]存放nums[0...i-1]的和
		int[] sums = new int[nums.length + 1];
		sums[0] = 0;
		for (int i = 1; i <= nums.length; i++) {
			sums[i] = sums[i - 1] + nums[i - 1];
		}

		int res = nums.length + 1;
		for (int l = 0; l < nums.length; l++) {
			for (int r = l; r < nums.length; r++) {
				// 使用sums[r+1] - sums[l] 快速获得nums[l...r]的和
				if (sums[r + 1] - sums[l] >= s) {
					res = Math.min(res, r - l + 1);
				}
			}
		}

		if (res == nums.length + 1) {
			return 0;
		}

		return res;
	}

	public static int minSubArrayLen3(int s, int[] nums) {
		if (s <= 0 || nums == null) {
			throw new IllegalArgumentException("Illigal Arguments");
		}
		int l = 0, r = -1;  //nums[l...r]为我们的滑动窗口
		int sum = 0;
		int res = nums.length + 1;
		//控制左边界就行，不是右边界
		while (l < nums.length) {
			//r + 1 判断只是为了防止下面的数组越界
			if (r + 1 < nums.length && sum < s) {
				r++;
				sum += nums[r];
			} else {
				sum -= nums[l];
				l++;
			}
			if (sum >= s) {
				res = Math.min(res, r - l + 1);
			}
		}
		if (res == nums.length + 1) {
			return 0;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(minSubArrayLen1(7, new int[]{2, 3, 1, 2, 4, 3}));
		System.out.println(minSubArrayLen2(7, new int[]{2, 3, 1, 2, 4, 3}));
	}
}
