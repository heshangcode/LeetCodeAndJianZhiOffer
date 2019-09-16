package com.hs.LeetCode.DP;

import java.util.HashSet;
import java.util.List;

/**
 * 思路1：暴力，回溯，超时
 * 思路2：记忆化搜索，自顶向下DP，超时
 * 思路3：DP
 * 1. 状态 boolean[n + 1] 长度为i的字符是否可以由字典里的字符组成
 * 2. 初始化 [0] = true
 * 3. 转移方程 [i] = (j:1 -> i){sub(j):[i - j]} j从1到i，看这段是否可以组成，
 * 4. 结果 boolean[n]
 * @Author heshang.ink
 * @Date 2019/9/15 17:15
 */
public class LeetCode139单词拆分Solution2 {

	boolean[] memo;

	public boolean wordBreak(String s, List<String> wordDict) {
		memo = new boolean[s.length()];
		return helper(s, new HashSet<>(wordDict), 0);
	}

	private boolean helper(String s, HashSet<String> wordDict, int start) {
		if (start == s.length()) {
			return true;
		}
		if (memo[start]) {
			return true;
		}

		for (int i = start + 1; i <= s.length(); i++) {
			if (wordDict.contains(s.substring(start, i)) && helper(s, wordDict, i)) {
				return memo[start] = true;
			}
		}
		return memo[start] = false;
	}
}
