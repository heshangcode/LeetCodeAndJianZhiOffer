package com.hs.JianZhiOffer.DP;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖 一次 该股票可能获得的利润是多少？
 *
 * 例如一只股票在某些时间节点的价格为[9, 11, 8, 5, 7, 12, 16, 14]。
 *
 * 如果我们能在价格为5的时候买入并在价格为16时卖出，则能收获最大的利润11。
 *
 * 样例
 * 输入：[9, 11, 8, 5, 7, 12, 16, 14]
 *
 * 输出：11
 *
 * 思路：用一个变量记录前i最小的值，每次比较
 * @Author heshang.ink
 * @Date 2019/10/14 21:00
 */
public class 股票的最大利润 {
	public int maxDiff(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int res = 0;
		int minv = nums[0];
		for (int i = 1; i < nums.length; i++) {
			//比较在哪一次卖掉，res最大
			res = Math.max(res, nums[i] - minv);
			//更新最小值
			minv = Math.min(minv, nums[i]);
		}
		return res;
	}
}
