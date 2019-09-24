package com.hs.JianZhiOffer;

/**
 * 思路1：递归
 *
 * @Author heshang.ink
 * @Date 2019/9/24 16:04
 */
public class 斐波拉契数列Solution1 {
	public int Fibonacci(int n) {
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 1;
		}
		return Fibonacci(n - 2) + Fibonacci(n - 1);
	}
}
