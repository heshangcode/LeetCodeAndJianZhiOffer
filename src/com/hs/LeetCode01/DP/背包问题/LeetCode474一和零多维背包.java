package com.hs.LeetCode01.DP.背包问题;

/**
 * 思路：
 * https://www.youtube.com/watch?v=R-U_pY0OBKI
 * 多维背包问题
 * 1. 状态 dp[i][j]   表示使用i个0和j个1能表示的字符串的最大数量
 * 2. 初始化
 * 3. 转移方程 dp[i][j] = max(dp[i][j],dp[i - zeros][j - ones] + 1) （当前这个不能装，这个能装+上一个的）
 * 4. 结果 dp[m][n]
 *
 * @Author heshang.ink
 * @Date 2019/9/15 16:29
 */
public class LeetCode474一和零多维背包 {
	public int findMaxForm(String[] strs, int m, int n) {
		if (strs.length == 0) {
			return 0;
		}
		int[][] dp = new int[m + 1][n + 1]; //多维费用问题的0-1背包问题。dp[i][j]表示使用i个0和j个1能表示的字符串的最大数量
		for (int k = 0; k < strs.length; k++) {
			int ones = 0, zeros = 0;    //统计这个字符里0 1 出现的次数
			for (char s : strs[k].toCharArray()) {
				if (s == '0') {
					zeros++;
				} else {
					ones++;
				}
			}

			for (int i = m; i >= zeros; i--) {
				for (int j = n; j >= ones; j--) {
					//转移方程
					dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
				}
			}
		}
		return dp[m][n];
	}
}
