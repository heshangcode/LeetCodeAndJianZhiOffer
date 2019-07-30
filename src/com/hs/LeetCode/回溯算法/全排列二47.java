package com.hs.LeetCode.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 给定一个可包含重复数字的序列，返回所有不重复的全排列。

 示例:

 输入: [1,1,2]
 输出:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/permutations-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author heshang.ink
 * @Date 2019/6/15 14:51
 */
public class 全排列二47 {
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> permuteUnique(int[] num) {
		ArrayList<Integer> list = new ArrayList<>();
		Arrays.sort(num);
		dfs(list, num, new boolean[num.length]);
		return res;
	}

	private void dfs(ArrayList<Integer> list, int[] num, boolean[] isUse) {
		if(num.length == list.size()) {
			res.add(new ArrayList<Integer>(list));
			return;
		}

		for(int i = 0; i < num.length; i++) {
			//是否备用
			if(isUse[i]) continue;
			//去重
			if(i > 0 && num[i - 1] == num[i] && !isUse[i - 1]) continue;
			list.add(num[i]);
			isUse[i] = true;
			dfs(list, num, isUse);
			isUse[i] = false;
			list.remove(list.size() - 1);

		}
	}

	public static void main(String[] args) {
		List<List<Integer>> lists = new 全排列二47().permuteUnique(new int[]{1, 1, 2, 3});
		System.out.println(lists);
	}

}
