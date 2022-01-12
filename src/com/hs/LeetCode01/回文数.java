package com.hs.LeetCode01;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/5/1 20:49
 */
public class 回文数 {
	public static void main(String[] args) {
		boolean palindrome = new 回文数().isPalindrome(121);
		System.out.println(palindrome);
	}

	public boolean isPalindrome(int x) {
		int m = x;
		if (x == 0) {
			return true;
		}
		int y = 0;
		while (x != 0) {
			y = y * 10 + x % 10;
			x /= 10;
		}
		if (m == y) {
			return true;
		} else {
			return false;
		}
	}
}
