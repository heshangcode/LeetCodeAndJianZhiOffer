package com.hs.JianZhiOffer.堆;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
 * <p>
 * 例如，如果输入数组[2, 3, 4, 2, 6, 2, 5, 1]及滑动窗口的大小3,那么一共存在6个滑动窗口，它们的最大值分别为[4, 4, 6, 6, 6, 5]。
 * <p>
 * 注意：
 * <p>
 * 数据保证k大于0，且k小于等于数组长度。
 * 样例
 * 输入：[2, 3, 4, 2, 6, 2, 5, 1] , k=3
 * <p>
 * 输出: [4, 4, 6, 6, 6, 5]
 * <p>
 * 思路：构建一个大小为k的大根堆，每次他的堆顶就是最大值
 * 时间复杂度O(nlogK)
 * @Author heshang.ink
 * @Date 2019/10/13 15:50
 */
public class 滑动窗口的最大值Solution1 {
	public int[] maxInWindows(int[] nums, int k) {
		if (k > nums.length || k < 1) {
			return null;
		}
		ArrayList<Integer> res = new ArrayList<>();
		//构建一个大小为k的大根堆
		PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
		for (int i = 0; i < k; i++) {
			heap.add(nums[i]);
		}
		//获取堆顶元素
		res.add(heap.peek());
		for (int i = k, j = 0; i < nums.length; i++, j++) {
			//这里是为了移除元素，所以用j
			heap.remove(nums[j]);
			heap.add(nums[i]);
			res.add(heap.peek());
		}
		int[] ans = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			ans[i] = res.get(i);
		}
		return ans;

	}
}
