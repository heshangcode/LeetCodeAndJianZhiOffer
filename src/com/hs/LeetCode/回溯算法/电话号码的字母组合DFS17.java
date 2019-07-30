package com.hs.LeetCode.回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/6/11 20:55
 */
public class 电话号码的字母组合DFS17 {
	public List<String> letterCombinations(String digits) {
		String[] ops = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		//装结果
		List<String> res = new ArrayList<>();
		//判断如果字符串为空
		if (digits.length() < 1) {
			return res;
		}
		dfs("", digits, 0, res, ops);
		return res;
	}

	/**
	 * @param s      每次进入一个节点的值
	 * @param digits 需要遍历的字符串
	 * @param i      记录DFS的深度
	 * @param res    记录每一次DFS结束的值
	 * @param ops    对应的目标串
	 */
	public void dfs(String s, String digits, int i, List<String> res, String[] ops) {
		//比如23，DFS到了3对应的长度，说明应该到底了，就该回溯了
		if (i == digits.length()) {
			res.add(s);
			return;
		}
		//比如23，第一次i=0，digits.charAt(0)=2，ops[2]='abc'，然后在abc里分别又取3
		//当前位可以选哪些
		String str = ops[digits.charAt(i) - '0'];
		for (int j = 0; j < str.length(); j++) {
			dfs(s + str.charAt(j), digits, i + 1, res, ops);
		}

	}
}
