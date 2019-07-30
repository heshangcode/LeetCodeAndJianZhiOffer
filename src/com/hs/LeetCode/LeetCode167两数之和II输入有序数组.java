package com.hs.LeetCode;

import java.util.Arrays;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路1：暴力法，O(n^2)
 * 思路2：数组有序，想到二分搜索，先找到一个数，剩下那个数在剩下的数组中二分找，O(nlogn)
 * 思路3：对撞指针，左右两端指针i j,
 * num[i] + num[j] < target,说明数字还比较小，i右移找大的，
 * num[i] + num[j] > target,说明数字比较大，j左移找小的，
 * 时间O(n),空间O(1)
 *
 * @Author heshang.ink
 * @Date 2019/7/29 16:41
 */
public class LeetCode167两数之和II输入有序数组 {
	public int[] twoSum1(int[] numbers, int target) {
		int[] twoNum = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			int one = numbers[i];
			int two = target - one;
			for (int j = i + 1; j < numbers.length; j++) {
				if (two == numbers[j]) {
					twoNum[0] = i + 1;
					twoNum[1] = j + 1;

				}
			}
		}
		return twoNum;
	}

	public static int[] twoSum2(int[] numbers, int target) {
		int[] twoNum = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			int one = numbers[i];
			int two = target - one;
			int i1 = binarySearch(numbers, i + 1, numbers.length - 1, two);
			if (i1 != -1) {
				twoNum = new int[]{i + 1, i1 + 1};
			}
		}
		return twoNum;
	}

	/**
	 * 二分查找
	 *
	 * @param nums
	 * @param l
	 * @param r
	 * @param target
	 * @return
	 */
	public static int binarySearch(int[] nums, int l, int r, int target) {
		while (l <= r) {
			int mid = (l + r) / 2;
			if (target == nums[mid]) {
				return mid;
			} else if (target < nums[mid]) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * 思路3
	 *
	 * @param numbers
	 * @param target
	 * @return
	 */
	public static int[] twoSum3(int[] numbers, int target) throws Exception {
		int i = 0;
		int j = numbers.length - 1;
		int[] twoS = new int[2];
		while (i < j) {
			int sum = numbers[i] + numbers[j];
			if (sum < target) {
				i++;
			} else if (target < sum) {
				j--;
			} else {
				twoS = new int[]{i + 1, j + 1};
				return twoS;
			}
		}
		throw new Exception("无解");
	}

	public static void main(String[] args) {
		int[] ints = twoSum2(new int[]{2, 7, 11, 15}, 9);
		System.out.println(Arrays.toString(ints));
	}
}
