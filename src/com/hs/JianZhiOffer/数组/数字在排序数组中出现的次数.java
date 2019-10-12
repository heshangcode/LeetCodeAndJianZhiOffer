package com.hs.JianZhiOffer.数组;

/**
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 例如输入排序数组[1, 2, 3, 3, 3, 3, 4, 5]和数字3，由于3在这个数组中出现了4次，因此输出4。
 * <p>
 * 样例
 * 输入：[1, 2, 3, 3, 3, 3, 4, 5] ,  3
 * <p>
 * 输出：4
 * 思路：1.暴力
 * 2. 利用二分，首先找到第一个k出现的下标，然后找到最后一个k出现的下标，然后相减+1，就是出现的次数
 *
 * @Author heshang.ink
 * @Date 2019/10/11 21:57
 */
public class 数字在排序数组中出现的次数 {
	public int getNumberOfK(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int l = 0, r = nums.length - 1;
		//注意二分模板
		while (l < r) {
			int mid = l + r >> 1;
			if (nums[mid] < k) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		if (nums[l] != k) {
			return 0;
		}

		int left = l;
		l = 0;
		r = nums.length - 1;
		//二分另外一个模板
		while (l < r){
			int mid = l + r + 1 >> 1;
			if (nums[mid] <= k) {
				l = mid;
			} else {
				r = mid - 1;
			}
		}
		return r - left + 1;

	}

	/*public int getNumberOfK(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		//找到第一个出现的下标
		int first = getFirstK(nums, k, 0, nums.length - 1);
		int last = getLastK(nums, k, 0, nums.length - 1);
		int res = 0;
		if (first > -1 && last > -1) {
			res = last - first + 1;
		}
		return res;
	}

	private int getFirstK(int[] nums, int k, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = start + (end - start) / 2;
		if (nums[mid] == k) {
			//这里就找到了第一次出现
			if ((mid > 0 && nums[mid - 1] != k) || mid == 0) {
				return mid;
			} else {
				end = mid - 1;
			}
		} else if (nums[mid] > k) {
			end = mid - 1;
		} else {
			start = mid + 1;
		}
		return getFirstK(nums, k, start, end);
	}

	private int getLastK(int[] nums, int k, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = start + (end - start) / 2;
		if (nums[mid] == k) {
			if ((mid < nums.length - 1 && nums[mid + 1] != k) || mid == nums.length - 1) {
				return mid;
			} else {
				start = mid + 1;
			}
		} else if (nums[mid] < k) {
			start = mid + 1;
		} else {
			end = mid - 1;

		}
		return getLastK(nums, k, start, end);
	}*/

}
