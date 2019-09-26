package com.hs.JianZhiOffer.贪心;

/**
 * 给你一根长度为 n 绳子，请把绳子剪成 m 段（m、n 都是整数，2≤n≤58 并且 m≥2）。
 *
 * 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]k[1] … k[m] 可能的最大乘积是多少？
 *
 * 例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到最大的乘积18。
 *
 * 样例
 * 输入：8
 *
 * 输出：18
 *
 * 找规律一个公式，尽量切成3为一段
 * n % 3 == 1,拆分2，剩余3
 * n % 3 == 2，拆分1个2，剩余3
 *
 *
 * @Author heshang.ink
 * @Date 2019/9/25 16:48
 */
public class 剪绳子 {
	public int cutRope(int number) {
		if (number == 2) {
			return 1;
		}
		if (number == 3) {
			return 2;
		}
		int res = 1;
		if (number % 3 == 1) {
			res *= 4;
			number -= 4;
		}
		if (number % 3 == 2) {
			res *= 2;
			number -= 2;
		}
		while (number > 0) {
			res *= 3;
			number -= 3;
		}
		return res;
	}
}
