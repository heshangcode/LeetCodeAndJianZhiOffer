package com.hs.LeetCode01.贪心算法;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心思路：
 * https://leetcode-cn.com/problems/non-overlapping-intervals/solution/tan-xin-suan-fa-zhi-qu-jian-diao-du-wen-ti-by-labu/
 * 把每一个区间根据end排序，找到第一个区间的结束，不想交，则下一个的start >= 这个end，然后递归
 * @Author heshang.ink
 * @Date 2019/9/22 21:50
 */
public class LeetCode435无重叠区间 {
	public int eraseOverlapIntervals(int[][] intvs) {
		if (intvs.length == 0) {
			return 0;
		}
		// 按 end 升序排序
		Arrays.sort(intvs, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[1] - b[1];
			}
		});
		// 至少有一个区间不相交
		int res = 1;
		// 排序后，第一个区间就是 x
		int x_end = intvs[0][1];
		for (int[] intv : intvs) {
			int start = intv[0];
			if (start >= x_end) {
				// 找到下一个选择的区间了
				res++;
				//更新x_end
				x_end = intv[1];
			}
		}
		return intvs.length - res;
	}
}
