package com.hs.LeetCode01;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/9/23 19:49
 */
public class TOPK问题 {
	public static List<Integer> solutionByHeap(int[] input, int k) {
		List<Integer> list = new ArrayList<>();
		if (k > input.length || k == 0) {
			return list;
		}
		Queue<Integer> queue = new PriorityQueue<>();
		for (int num : input) {
			if (queue.size() < k) {
				queue.add(num);
			} else if (queue.peek() < num){
				queue.poll();
				queue.add(num);
			}
		}
		while (k-- > 0) {
			list.add(queue.poll());
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println(solutionByHeap(new int[]{2, 7, 8, 0, 1, 5}, 3));

	}
}
