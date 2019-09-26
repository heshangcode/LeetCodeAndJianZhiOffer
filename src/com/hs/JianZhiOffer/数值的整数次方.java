package com.hs.JianZhiOffer;

/**
 * 实现函数double Power(double base, int exponent)，求base的 exponent次方。
 *
 * 不得使用库函数，同时不需要考虑大数问题。
 *
 * 注意：
 *
 * 不会出现底数和指数同为0的情况
 * 样例1
 * 输入：10 ，2
 *
 * 输出：100
 * 样例2
 * 输入：10 ，-2
 *
 * 输出：0.01
 *
 * 注意区分负数和正数，负数就是倒数
 * @Author heshang.ink
 * @Date 2019/9/25 17:11
 */
public class 数值的整数次方 {
	public double Power(double base, int exponent) {
		double res = 1;
		for (int i = 0; i < Math.abs(exponent); i++) {
			res *= base;
		}
		if (exponent < 0) {
			res = 1 / res;
		}
		return res;
	}

}
