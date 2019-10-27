package com.hs.LeetCode.堆和队列;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *  
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路1：
 * 1.利用大根堆构建k大小的堆，
 * 2.遍历数组进行
 * 思路2：
 * 用一个队列（需要判断大小限制）来存值，如果进来的值比前面的值大，说明前面的值永无出头之日，就给pop出去
 *
 *
 * @Author heshang.ink
 * @Date 2019/10/13 16:15
 */
public class LeetCode239滑动窗口最大值Solution2 {
	public int[] maxSlidingWindow(int[] nums, int k) {
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
			//如果队列里的前面元素小于要加入进来的元素，就给pop出去
			while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
				queue.pollLast();
			}
			//把这个元素加入到队列
			queue.addLast(i);
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
