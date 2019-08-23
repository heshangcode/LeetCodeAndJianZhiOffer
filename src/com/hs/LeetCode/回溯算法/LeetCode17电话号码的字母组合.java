package com.hs.LeetCode.回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 思路：标准回溯思路
 * @Author heshang.ink
 * @Date 2019/8/19 17:29
 */
public class LeetCode17电话号码的字母组合 {
	List<String> res = new ArrayList<>();
	String[] ops = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public List<String> letterCombinations(String digits) {
		if (digits.isEmpty()) {
			return res;
		}
		dfs(digits, 0, "");
		return res;
	}

	public void dfs(String digits,int index,String path) {
		//找到的组合符合要求了，进行放进res
		if (path.length() == digits.length()) {
			res.add(path);
			return;
		}
		//当前位置是哪个数字
		char c = digits.charAt(index);
		//找到这个数字代表那些字母
		String str = ops[c - '0'];
		//依次枚举字母，和他下一个数字代表的字母
		for (int i = 0; i < str.length(); i++) {
			dfs(digits,index + 1,path + str.charAt(i));
		}
		return;
	}
}
