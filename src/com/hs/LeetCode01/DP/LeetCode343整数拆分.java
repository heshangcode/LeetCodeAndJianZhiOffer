package com.hs.LeetCode01.DP;

/**
 * https://leetcode-cn.com/problems/integer-break/
 * 思路1：递归方法，超时
 * 思路2：在思路1上进行画树，发现很多重复的计算，想到dp，最优子结构问题，子结构最优了，就代表最后也是最优的
 * 自顶向下搜索
 * 1. 状态
 * 2. 初始化
 * 3. 转移方程
 * 4. 结构
 * 思路3：自底向上，标准DP
 *
 * @Author heshang.ink
 * @Date 2019/9/6 15:19
 */
public class LeetCode343整数拆分 {

	//状态，存子问题的最优解
	int[] memo;

	public int integerBreak(int n) {
		if (n < 2) {
			return n;
		}
		//memo[i] 表示将数字i分割（至少分割成两部分）后得到的最大乘积
		memo = new int[n + 1];
		memo[1] = 1;
		for (int i = 2; i <= n; i++) {
			// 求解memo[i]
			for (int j = 1; j < i; j++) {
				// j + (i - j)
				memo[i] = max3(memo[i], j * (i - j), j * memo[i - j]);
			}
		}
		return memo[n];
	}

	/**
	 * 思路1:
	 *
	 * @param n
	 * @return
	 */
	// 将n进行分割(至少分割两部分), 可以获得的最大乘积
	private int recursive(int n) {
		//递归基
		if (n == 1) {
			return 1;
		}
		int res = -1;

		for (int i = 1; i < n; i++) {
			//进行分割 i + (n - i)
			res = max3(res, i * (n - i), i * recursive(n - i));
		}
		return res;

	}

	private int max3(int a, int b, int c) {
		return Math.max(a, Math.max(b, c));
	}

	/**
	 * 思路2：自顶向下，记忆化搜索
	 *
	 * @param n
	 * @return
	 */
	// 将n进行分割(至少分割两部分), 可以获得的最大乘积
	private int dp2(int n) {
		//递归基
		if (n == 1) {
			return 1;
		}
		if (memo[n] != 0) {
			return memo[n];
		}
		int res = -1;

		for (int i = 1; i < n; i++) {
			//进行分割 i + (n - i)
			res = max3(res, i * (n - i), i * dp2(n - i));
		}
		memo[n] = res;
		return res;

	}

}
