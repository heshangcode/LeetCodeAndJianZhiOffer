package com.hs.LeetCode01;

import java.util.Random;

/**
 * 打乱一个没有重复元素的数组。
 * <p>
 * 示例:
 * <p>
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] arr = {1,2,3};
 * Solution solution = new Solution(arr);
 * <p>
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 * <p>
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 * <p>
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shuffle-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：利用随机数
 * @Author heshang.ink
 * @Date 2019/10/28 13:02
 */
public class LeetCode384洗牌算法打乱数组 {
	class Solution {

		private int[] old;
		private int[] arr;
		Random rand = new Random();

		public Solution(int[] nums) {
			arr = nums;
			old = nums.clone();
		}

		/**
		 * Resets the array to its original configuration and return it.
		 * @return
		 */
		public int[] reset() {
			arr = old;
			old = old.clone();
			return old;
		}

		/**
		 * Resets the array to its original configuration and return it.
		 */
		public int[] shuffle() {
			int n = arr.length;
			for (int i = 0; i < n; i++) {
				//从i到最后随机选一个元素
				int rand = randInt(i, n);
				swap(i, rand);
			}
			return arr;
		}

		// 得到一个在闭区间 [min, max] 内的随机整数
		public int randInt(int min, int max) {

			return rand.nextInt(max - min) + min;
		}

		private void swap(int i, int j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
}
