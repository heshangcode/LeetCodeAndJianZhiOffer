package com.hs.LeetCode01.DP;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：说了只买卖一次
 *
 * @Author heshang.ink
 * @Date 2019/10/14 21:36
 */
public class LeetCode121买卖股票的最佳时机 {
	public int maxProfit(int[] nums) {
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
