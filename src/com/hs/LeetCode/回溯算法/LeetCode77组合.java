package com.hs.LeetCode.回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/
 * 思路：依然是递归+回溯问题
 * 问题就在于
 * 比如1,2,3,4，取2个数组合
 * 第一层：取1,              2,          3,       4
 * 第二层：在2,3,4中取   在3,4中取     在4中取
 * 好的思路：https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
 * 优化版：剪枝：
 * @Author heshang.ink
 * @Date 2019/8/22 9:07
 */
public class LeetCode77组合 {
	//装结果
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> combine(int n, int k) {
		if (n <= 0 || k <= 0 || n < k) {
			return res;
		}
		dfs(n, k, 1, new ArrayList<Integer>());
		return res;
	}

	// 求解C(n,k), 当前已经找到的组合存储在path中, 需要从start开始搜索新的元素
	private void dfs(int n, int k, int start, ArrayList<Integer> path) {
		if (k == path.size()) {
			res.add(new ArrayList<>(path));
			return;
		}
		/*for (int i = start; i <= n; i++) {
			path.add(i);
			dfs(n, k, i + 1, path);

			path.remove(path.size() - 1);
		}*/
		//优化版：剪枝
		// 还有k - path.size()个空位, 所以, [i...n] 中至少要有 k - path.size() 个元素
		// i最多为 n - (k - path.size()) + 1
		for (int i = start; i <= n - (k - path.size()) + 1; i++) {
			path.add(i);
			dfs(n, k, i + 1, path);

			path.remove(path.size() - 1);
		}
		return;
	}
}
