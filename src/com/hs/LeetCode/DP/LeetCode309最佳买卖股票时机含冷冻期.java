package com.hs.LeetCode.DP;

/**
 * 一个方法团灭 6 道股票问题 - 最佳买卖股票时机含冷冻期 - 力扣（LeetCode）
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/yi-ge-fang-fa-tuan-mie-6
 * -dao-gu-piao-wen-ti-by-lab/
 *
 * @Author heshang.ink
 * @Date 2019/9/12 18:41
 */
public class LeetCode309最佳买卖股票时机含冷冻期 {
	public int maxProfit(int[] prices) {
		int n = prices.length;
		int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
		int dp_pre_0 = 0; // 代表 dp[i-2][0]
		for (int i = 0; i < n; i++) {
			int temp = dp_i_0;
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
			dp_pre_0 = temp;
		}
		return dp_i_0;
	}
}
