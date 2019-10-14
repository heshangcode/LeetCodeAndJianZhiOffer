package com.hs.JianZhiOffer.堆;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

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
 * 思路：利用一个双端队列来做，时间复杂度O(N)
 *
 * @Author heshang.ink
 * @Date 2019/10/13 15:50
 */
public class 滑动窗口的最大值Solution2 {
	public int[] maxInWindows(int[] nums, int k) {
		if (k > nums.length || k < 1) {
			return new int[0];
		}
		ArrayList<Integer> res = new ArrayList<>();
		//主要存下标
		Deque<Integer> queue = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {
			//这里是判断队列里的元素数量超出了k，就应该移除左边的
			while (!queue.isEmpty() && queue.peekFirst() <= i - k) {
				queue.pollFirst();
			}
			//如果队列里的元素小于要加入进来的元素，就给pop出去，但是是从后到前开始poll的
			while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
				queue.pollLast();
			}
			//把这个元素加入到队列
			queue.addLast(i);
			System.out.println(queue);
			//加入结果
			if (i >= k - 1) {
				res.add(nums[queue.peekFirst()]);
			}
		}
		int[] ans = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			ans[i] = res.get(i);
		}
		return ans;

	}
}
