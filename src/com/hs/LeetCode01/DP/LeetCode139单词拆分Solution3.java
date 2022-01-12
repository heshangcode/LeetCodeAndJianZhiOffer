package com.hs.LeetCode01.DP;

import java.util.HashSet;
import java.util.List;

/**
 * [Leetcode 139/140] Word Break I/II - YouTube
 * https://www.youtube.com/watch?v=pYKGRZwbuzs
 * <p>
 * 思路1：暴力，回溯，超时
 * 思路2：记忆化搜索，自顶向下DP，超时
 * 思路3：DP
 * 1. 状态 boolean[n + 1] 长度为i的字符是否可以由字典里的字符组成
 * 2. 初始化 [0] = true
 * 3. 转移方程 [i] = (j:1 -> i){sub(j):[i - j]} j从1到i，看这段是否可以组成，
 * 4. 结果 boolean[n]
 *
 * @Author heshang.ink
 * @Date 2019/9/15 17:15
 */
public class LeetCode139单词拆分Solution3 {

	public boolean wordBreak(String s, List<String> wordDict) {
		if (s == null || wordDict == null) {
			return false;
		}
		HashSet<String> dict = new HashSet<>(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = i; j > 0; j--) {
				String sub = s.substring(i - j, i);
				if (dict.contains(sub) && dp[i - j] == true) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}

}
