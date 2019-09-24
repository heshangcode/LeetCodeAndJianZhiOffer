package com.hs.LeetCode.DP;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/submissions/
 * 思路4，一维数组优化
 *
 * @Author heshang.ink
 * @Date 2019/8/23 10:51
 */
public class LeetCode70爬楼梯Solution4 {
	public int climbStairs(int n) {
		int a = 1;
		int b = 1;
		for (int i = 2; i <= n; i++) {
			int c = a + b;
			a = b;
			b = c;
		}
		return b;
	}
}
