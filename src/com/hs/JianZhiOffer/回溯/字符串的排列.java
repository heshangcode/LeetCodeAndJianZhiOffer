package com.hs.JianZhiOffer.回溯;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * <p>
 * 思路：lc 47 注意有重复元素
 *
 * @Author heshang.ink
 * @Date 2019/10/6 9:11
 */
public class 字符串的排列 {

	ArrayList<String> res = new ArrayList<>();

	boolean[] visited;

	public ArrayList<String> Permutation(String str) {
		if (str == null || str.length() == 0) {
			return res;
		}
		char[] nums = str.toCharArray();
		Arrays.sort(nums);
		visited = new boolean[nums.length];
		dfs(nums, "");
		return res;

	}

	private void dfs(char[] nums, String path) {
		if (path.length() == nums.length) {
			res.add(path);
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			//这个位置字符没有被用
			if (!visited[i]) {
				//保证不重复
				if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
					continue;
				}
				visited[i] = true;
				dfs(nums, path + nums[i]);
				visited[i] = false;
			}

		}

	}
}
