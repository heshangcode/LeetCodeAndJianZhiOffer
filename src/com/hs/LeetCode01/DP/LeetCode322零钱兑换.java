package com.hs.LeetCode01.DP;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * 思路：
 * 动态规划套路详解 - 零钱兑换 - 力扣（LeetCode）
 * https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-tao-lu-xiang-jie-by-wei-lai-bu-ke/
 *
 * @Author heshang.ink
 * @Date 2019/9/12 16:54
 */
public class LeetCode322零钱兑换 {
	/**
	 * 1.暴力
	 *
	 * @param coins
	 * @param amount
	 * @return
	 */
	public int coinChange1(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}
		int res = 10000000;
		for (int i = 0; i < coins.length; i++) {
			// 金额不可达
			if (amount - coins[i] < 0) {
				continue;
			}
			int subProb = coinChange1(coins, amount - coins[i]);

			//子问题无解
			if (subProb == -1) {
				continue;
			}

			//更新res
			res = Math.min(res, subProb);
		}
		return res == 10000000 ? -1 : res;
	}

	/**
	 * 记忆化搜索
	 *
	 * @param coins
	 * @param amount
	 * @return
	 */
	int[] memo;

	public int coinChange2(int[] coins, int amount) {
		memo = new int[amount + 1];
		Arrays.fill(memo, -2);
		helper(coins, amount);
		return memo[coins.length];
	}

	private int helper(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}
		//记忆化里有，直接返回
		if (memo[amount] != -2) {
			return memo[amount];
		}
		int res = 10000000;
		for (int i = 0; i < coins.length; i++) {
			// 金额不可达
			if (amount - coins[i] < 0) {
				continue;
			}
			int subProb = helper(coins, amount - coins[i]);
			// 子问题无解
			if (subProb == -1) {
				continue;
			}
			res = Math.min(res, subProb + 1);
		}
		// 记录本轮答案
		memo[amount] = (res == 100000000) ? -1 : res;
		return memo[amount];
	}

	/**
	 * 自下而上的DP
	 *
	 * @param coins
	 * @param amount
	 * @return
	 */
	public int coinChange3(int[] coins, int amount) {

		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (amount >= coins[j]) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}

			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		System.out.println(new LeetCode322零钱兑换().coinChange2(new int[]{1, 2, 5}, 11));
	}
}
