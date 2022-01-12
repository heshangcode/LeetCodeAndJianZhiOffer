package com.hs.LeetCode01;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 思路1：把非0放进另外一个数组，然后再放回去，时间和空间都是O(n)
 * 思路2：双指针法，滑动窗口法，k指针指向非0元素，剩下k到i的之间赋值为0
 * 思路3：双指针法，k和i指向的值互相交换，这样后面就不需要继续给补0了。优化，如果都没有非0元素呢
 *
 * @Author heshang.ink
 * @Date 2019/7/24 15:36
 */
public class 移动零283 {
	public static void moveZeroes3(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int k = 0;  // nums中，[0...k]的元素均为非0元素
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				// 这个判断是优化，如果整个数组都是非0元素呢，就不用交换位置
				if (i != k) {
					swap(nums, k++, i);
				} else {
					k++;
				}

			}
		}
	}

	public static void swap(int[] nums, int k, int i) {
		int swap = nums[i];
		nums[i] = nums[k];
		nums[k] = swap;
	}

	public static void moveZeroes2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int k = 0;  // nums中，[0...k]的元素均为非0元素
		for (int i = 0; i < nums.length; i++) {
			//如果数组中非0元素都依次放置在[0...k]中
			if (nums[i] != 0) {
				nums[k++] = nums[i];
			}
		}
		// nums剩下的位置放置为0
		for (int i = k; i < nums.length; i++) {
			nums[i] = 0;
		}

	}

	public static void moveZeroes(int[] nums) {

		if (nums == null || nums.length == 0) {
			return;
		}
		ArrayList<Integer> noZeroesElement = new ArrayList<>();
		//非 0 放入ArrayList中
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				noZeroesElement.add(nums[i]);
			}
		}
		//将noZeroesElement中的所有元素依次放入到nums开始的位置
		for (int i = 0; i < noZeroesElement.size(); i++) {
			nums[i] = noZeroesElement.get(i);
		}
		// 讲nums剩下的位置放置为0
		for (int i = noZeroesElement.size(); i < nums.length; i++) {
			nums[i] = 0;
		}
	}

	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 3, 12};
		moveZeroes3(nums);
		System.out.println(Arrays.toString(nums));

	}
}
