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
 *
 * @Author heshang.ink
 * @Date 2019/10/6 11:09
 */
public class 数据流中的中位数Solution1 {

	// 左半边的元素 < 右半边的元素，如果个数为奇数，右边的数比左边多一个
	// 大根堆，存储左半边元素
	private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
	// 小根堆，存储右半边元素
	private PriorityQueue<Integer> right = new PriorityQueue<>();

	//当前数据流读入的元素个数
	private int N = 0;

	public void Insert(Integer num) {
		if (N % 2 == 0) {
			/**
			 * N 为偶数的情况下插入到右半边
			 * 因为右半边的元素 > 左半边的元素，但是新插入的元素不一定比左半边的元素大，
			 * 所以先放入左半边，左半边大根堆，就把最大的堆顶元素放入到右半边
			 */
			left.add(num);
			right.add(left.poll());
		} else {
			right.add(num);
			left.add(right.poll());
		}
		N++;
	}

	public Double GetMedian() {
		if (N % 2 == 0) {
			return (left.peek() + right.peek()) / 2.0;
		} else {
			return (double) right.peek();
		}
	}
}
