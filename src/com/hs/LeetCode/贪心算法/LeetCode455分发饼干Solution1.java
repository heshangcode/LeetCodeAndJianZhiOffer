package com.hs.LeetCode.贪心算法;

import java.util.Arrays;

/**
 * 思路1：贪心算法
 * 先尝试满足最贪心的小朋友
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 *
 * @Author heshang.ink
 * @Date 2019/9/22 19:48
 */
public class LeetCode455分发饼干Solution1 {
	public int findContentChildren(int[] g, int[] s) {

		Arrays.sort(g);
		Arrays.sort(s);

		int gi = g.length - 1, si = s.length - 1;
		int res = 0;
		while (gi >= 0 && si >= 0) {
			if (s[si] >= g[gi]) {
				res++;
				gi--;
				si--;
			} else {
				gi--;
			}
		}
		return res;
	}
}
