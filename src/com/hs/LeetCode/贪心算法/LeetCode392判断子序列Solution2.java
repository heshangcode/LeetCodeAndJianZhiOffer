package com.hs.LeetCode.贪心算法;

/**
 * 思路2：动态规划
 *
 * @Author heshang.ink
 * @Date 2019/9/22 20:23
 */
public class LeetCode392判断子序列Solution2 {
	public boolean isSubsequence(String s, String t) {
		if (s.length() == 0) {
			return true;
		}
		// dp[i][j] 表示s的前i 是否为 t的前j的子序列
		boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
		//初始化，空串肯定是t的前j的子序列
		for (int j = 0; j < t.length(); j++) {
			dp[0][j] = true;
		}
		//转移方程
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= t.length(); j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = dp[i][j - 1];
				}
			}
		}
		return dp[s.length()][t.length()];
	}
}
