package com.hs.JianZhiOffer;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/8/9 20:33
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int m, n;
		// 读取输入，直到没有整型数据可读
		while (sc.hasNextInt()) {
			m = sc.nextInt();
			n = sc.nextInt();
			if (100 <= m && m <= n && n <= 999) {
				boolean isHave = false;
				int count = 0;
				for (int i = m ; i <= n; i++) {
					int sum = 0;
					int num = i;
					while (num > 0) {
						sum += Math.pow(num % 10, 3);
						num /= 10;
					}
					if (sum == i) {
						count++;
						isHave = true;
						if (count == 1) {
							System.out.print(i);
						} else {
							System.out.print(" " + i);
						}

					}
				}
				if (!isHave) {
					System.out.println("no");
				}
			}

		}

	}
}
