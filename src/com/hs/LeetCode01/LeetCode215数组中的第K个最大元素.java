package com.hs.LeetCode01;

import java.util.Arrays;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路1：暴力法，排好序，根据下标然后找到第k大的数
 * 思路2：
 *
 * @Author heshang.ink
 * @Date 2019/7/29 15:27
 */
public class LeetCode215数组中的第K个最大元素 {
	public static int findKthLargest1(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	public static int findKthLargest2(int[] nums, int k) {
		return quickSort(nums, 0, nums.length - 1, k);

	}

	public static int quickSort(int[] nums, int left, int right, int k) {
		//递归基
		if (left < right) {
			//找基准数
			int p = nums[left];
			//使用low和high指针
			int low = left;
			int high = right;
			//遍历数组
			while (low < high) {
				//如果右边的数比基准数大
				while (p < nums[high] && low < high) {
					high--;
				}
				//如果右边的数比基准数小,把右边数移动到左边
				nums[low] = nums[high];
				//如果左边的数比基准数小
				while (nums[low] <= p && low < high) {
					low++;
				}
				//如果左边的数比基准数大,把左边数移动到右边
				nums[high] = nums[low];
			}
			//把标准点放进正确位置
			nums[low] = p;
			if (low == k - 1) {
				return nums[low];
			}else if (k - 1 < low) {
				//递归处理左边的数据
				quickSort(nums, left, low, k);
			}else{
				//递归处理右边的数据
				quickSort(nums, low + 1, right, k);
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(findKthLargest2(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
		System.out.println(findKthLargest2(new int[]{3, 2, 1, 5, 6, 4}, 2));

	}
}
