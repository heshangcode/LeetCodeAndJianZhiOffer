package com.hs.JianZhiOffer.数组;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的k个数。
 *
 * 注意：
 *
 * 数据保证k一定小于等于输入数组的长度;
 * 输出数组内元素请按从小到大顺序排序;
 * 样例
 * 输入：[1,2,3,4,5,6,7,8] , k=4
 *
 * 输出：[1,2,3,4]
 * 思路2：大小为k的最小堆
 * 复杂度：O(NlogK) + O(K)
 * 特别适合处理海量数据
 * 应该使用大顶堆来维护最小堆，而不能直接创建一个小顶堆并设置一个大小，企图让小顶堆中的元素都是最小元素。
 *
 * 维护一个大小为 K 的最小堆过程如下：在添加一个元素之后，如果大顶堆的大小大于 K，那么需要将大顶堆的堆顶元素去除。
 *
 * @Author heshang.ink
 * @Date 2019/10/6 10:35
 */
public class 最小的k个数Solution2 {
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] nums, int k) {
		ArrayList<Integer> res = new ArrayList<>();
		if (k > nums.length) {
			return res;
		}
		//大根堆
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
		//往大根堆里放值，不断变换
		for (int i = 0; i < nums.length; i++) {
			maxHeap.add(nums[i]);
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		return new ArrayList<>(maxHeap);
	}


}
