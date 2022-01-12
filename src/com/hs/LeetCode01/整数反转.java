package com.hs.LeetCode01;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * @Author heshang.ink
 * @Date 2019/5/1 18:10
 */
public class 整数反转 {
	public static void main(String[] args) {
		int reverse = new 整数反转().reverse(320);
		System.out.println(reverse);
	}

	public int reverse(int x) {
		int sum = 0;
		if (x == 0 || x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
			return 0;
		} else if (x > 0) {
			while (x > 0) {
				sum *= 10;
				sum = sum + x % 10;
				x /= 10;
			}
		} else {
			x = 0 - x;
			while (x > 0) {
				sum *= 10;
				sum = sum + x % 10;
				x /= 10;
			}
			sum = 0 - sum;
		}

		return sum;
	}
}
