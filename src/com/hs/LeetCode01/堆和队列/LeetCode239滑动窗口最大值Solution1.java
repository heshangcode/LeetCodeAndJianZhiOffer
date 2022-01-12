package com.hs.LeetCode01.堆和队列;

import java.util.ArrayList;
import java.util.PriorityQueue;

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
 * 思路：
 * 1.利用大根堆构建k大小的堆，
 * 2.遍历数组进行
 *
 * @Author heshang.ink
 * @Date 2019/10/13 16:15
 */
public class LeetCode239滑动窗口最大值Solution1 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		ArrayList<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0 || k < 1) {
			return null;
		}
		PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
		for (int i = 0; i < k; i++) {
			heap.add(nums[i]);
		}
		res.add(heap.peek());
		for (int i = 0, j = k; j < nums.length; i++, j++) {
			heap.remove(nums[i]);
			heap.add(nums[j]);
			res.add(heap.peek());
		}
		int[] ans = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			ans[i] = res.get(i);
		}
		return ans;
	}
}
