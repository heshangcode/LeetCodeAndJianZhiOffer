package com.hs.JianZhiOffer.数组;

import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？
 * <p>
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * <p>
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>
 * 样例
 * 输入：1, 2, 3, 4
 * <p>
 * 输出：1,1.5,2,2.5
 * <p>
 * 解释：每当数据流读入一个数据，就进行一次判断并输出当前的中位数。
 * <p>
 * 思路：利用大根堆小根堆的思想
 * 但是可以用极限考虑，每次直接先放入一个小根堆里，然后再做调整
 *
 * @Author heshang.ink
 * @Date 2019/10/6 11:09
 */
public class 数据流中的中位数Solution2 {

	// 左半边的元素 < 右半边的元素，如果个数为奇数，右边的数比左边多一个
	// 大根堆，存储左半边元素
	private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
	// 小根堆，存储右半边元素
	private PriorityQueue<Integer> right = new PriorityQueue<>();

	public void Insert(Integer num) {
		right.add(num);
		//如果大根堆的堆顶比小根堆的堆顶值大，交换两个的值
		if (left.size() > 0 && right.peek() < left.peek()) {
			Integer maxV = left.poll();
			Integer minV = right.poll();
			left.add(minV);
			right.add(maxV);
		}
		//维持两个堆的数量
		if (right.size() > left.size() + 1) {
			left.add(right.poll());
		}

	}

	public Double GetMedian() {
		if ((left.size() + right.size()) % 2 == 0) {
			return (left.peek() + right.peek()) / 2.0;
		} else {
			return (double) right.peek();
		}
	}
}
