package com.hs.JianZhiOffer;

/**
 * 0, 1, …, n-1这n个数字(n>0)排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。
 *
 * 求出这个圆圈里剩下的最后一个数字。
 *
 * 样例
 * 输入：n=5 , m=3
 *
 * 输出：3
 *
 * AcWing 82. 圆圈中最后剩下的数字 - AcWing
 * https://www.acwing.com/solution/acwing/content/796/
 * @Author heshang.ink
 * @Date 2019/10/14 18:27
 */
public class 圆圈中最后剩下的数字 {
	public int lastRemaining(int n, int m) {
		if (n == 0)     /* 特殊输入的处理 */
			return -1;
		if (n == 1)     /* 递归返回条件 */
			return 0;
		return (lastRemaining(n - 1, m) + m) % n;
	}
}
