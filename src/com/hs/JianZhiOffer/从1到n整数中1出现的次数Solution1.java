package com.hs.JianZhiOffer;

/**
 * 输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如输入12，从1到12这些整数中包含“1”的数字有1，10，11和12，其中“1”一共出现了5次。
 * <p>
 * 样例
 * 输入： 12
 * 输出： 5
 * <p>
 * 暴力：直接每次判断取余看个位是否为1
 * 时间复杂度O(nlogn)
 * @Author heshang.ink
 * @Date 2019/10/7 8:12
 */
public class 从1到n整数中1出现的次数Solution1 {
	public int NumberOf1Between1AndN_Solution(int n) {
		int res = 0;
		for (int i = 1; i <= n; i++) {
			int j = i;
			while (j > 0) {
				if (j % 10 == 1) {
					res++;
				}
				j /= 10;
			}
		}
		return res;
	}
}
