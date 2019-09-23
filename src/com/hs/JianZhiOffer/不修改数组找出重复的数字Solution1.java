package com.hs.JianZhiOffer;

/**
 * https://www.acwing.com/problem/content/description/15/
 * 抽屉原理，二分
 *
 * @Author heshang.ink
 * @Date 2019/9/23 17:35
 */
public class 不修改数组找出重复的数字Solution1 {
	public int duplicateInArray(int[] nums) {
		int l = 1, r = nums.length - 1; //这里的l和r是1~n的数字不是下标
		while (l < r) {
			int mid = l + r >> 1;   //划分的区间：[l,mid],[mid + 1,r]
			int s = 0; //计数
			//循环遍历数组按照[1~mid],[mid+1~r]分好
			for (int x : nums) {
				if (x >= l && x <= mid) {
					s++;
				}
			}
			if (s > mid - l + 1) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}
}
