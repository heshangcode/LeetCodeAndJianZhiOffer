package com.hs.LeetCode;

/**
 * 判断一个无符号的整数是不是2的n次方
 * 利用位运算，如果是2的n次方就是，2^0=0,2^1=10(2),2^2=100(2)
 * 假设是4,4-1 = 3 = 011(2)，两个位运算上 ==0
 * @Author heshang.ink
 * @Date 2019/10/27 16:54
 */
public class 判断是否2的n次方 {
	public boolean panduan(int x) {
		if (x == 0) {
			return true;
		} else {
			return (x & (x - 1)) == 0 ? true : false;
		}
	}

	public static void main(String[] args) {
		while (true) {
			System.out.println("------");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
