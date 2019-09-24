package com.hs.LeetCode.DP;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/submissions/
 * 思路1：斐波拉契递归，超时
 * 思路2：自顶向下的记忆搜索，
 * 思路3：思路2改的递推，动态规划
 * @Author heshang.ink
 * @Date 2019/8/23 10:51
 */
public class LeetCode70爬楼梯 {
	public int climbStairs1(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		return climbStairs1(n - 1) + climbStairs1(n - 2);
	}

	// 存重叠子问题的值
	int[] memo;
	public int climbStairs2(int n) {
		memo = new int[n + 1];
		//给memo全部填为-1
		Arrays.fill(memo, -1);
		return dp2(n);
	}

	private int dp2(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (memo[n] == -1) {
			memo[n] = dp2(n - 1) + dp2(n - 2);
		}
		return memo[n];
	}

	public int climbStairs3(int n) {
		int[] memo = new int[n + 1];
		memo[0] = 1;
		memo[1] = 1;
		for (int i = 2; i <= n; i++) {
			memo[i] = memo[i - 1] + memo[i - 2];
		}
		return memo[n];
	}






}
