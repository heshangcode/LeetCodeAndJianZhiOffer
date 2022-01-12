package com.hs.LeetCode01.贪心算法;

import java.util.Arrays;

/**
 * 思路2：先尝试满足最不贪心的小朋友
 *
 * @Author heshang.ink
 * @Date 2019/9/22 20:02
 */
public class LeetCode455分发饼干Solution2 {
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);

		int gi = 0, si = 0;
		int res = 0;
		while(gi < g.length && si < s.length){
			if (s[si] >= g[gi]) {
				res++;
				gi++;
				si++;
			} else {
				si++;
			}
		}
		return res;

	}
}
