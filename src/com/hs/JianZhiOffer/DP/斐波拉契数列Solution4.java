package com.hs.JianZhiOffer.DP;

/**
 * 思路3：一维数组优化
 *
 * @Author heshang.ink
 * @Date 2019/9/24 16:04
 */
public class 斐波拉契数列Solution4 {

	public int Fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		int a = 0, b = 1;
		for (int i = 2; i <= n; i++) {
			int c = a + b;
			a = b;
			b = c;
		}
		return b;
	}

}
