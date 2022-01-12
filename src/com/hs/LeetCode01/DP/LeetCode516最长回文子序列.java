package com.hs.LeetCode01.DP;

/**
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 * <p>
 * 示例 1:
 * 输入:
 * <p>
 * "bbbab"
 * 输出:
 * <p>
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路：
 * 当⾸尾的两个字符相等时：dp[0][n - 1] = dp[1][n - 2] + 2
 * 区间规划 / Interval Programming
 * 递归公式：
 * 否则：dp[0][n - 1] = max( dp[1][n - 1], dp[0][n - 2])
 *
 * 考虑三个情况：a -》 dp[i][i] =1
 *     a **** a s[i] == s[j] dp[i][j] = dp[i+1][j- 1] + 2
 *     ab***b dp[i][j] = dp[i + 1][j]
 *     a***ab dp[i][j] = dp[i][j - 1]
 *
 * @Author heshang.ink
 * @Date 2019/10/29 10:20
 */
public class LeetCode516最长回文子序列 {
	public int longestPalindromeSubseq(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		//一个字符就是1个解，为1
		for (int i = 0; i < n; i++) dp[i][i] = 1;
		for (int len = 2; len <= n; len++) {
			for (int i = 0; i < n - len + 1; i++) {
				int j = i + len - 1;
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[0][n - 1];
	}

}
