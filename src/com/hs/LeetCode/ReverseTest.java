package com.hs.LeetCode;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/4/1 19:32
 */
public class ReverseTest {
	public static void main(String[] args) {
		Reverse reverse = new Reverse();
		reverse.push(1);
		reverse.push(2);
		reverse.push(3);
		reverse.push(4);
		reverse.push(5);
		reverse.reverseStack();
		System.out.println(reverse.pop());
	}
}
