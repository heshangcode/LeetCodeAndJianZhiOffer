package com.hs.LeetCode01;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/5/1 21:16
 */
public class 罗马数字转整数 {
	public int romanToInt(String s) {
		int n = s.length();
		int roman_int = 0;
		//首先一个个遍历字符
		for (int i = 0; i < n; i++) {
			//然后比如字符，进行运算
			switch (s.charAt(i)) {
				case 'I':
					roman_int = roman_int + 1;
					break;
				case 'V':
					roman_int = roman_int + 5;
					break;
				case 'X':
					roman_int = roman_int + 10;
					break;
				case 'L':
					roman_int = roman_int + 50;
					break;
				case 'C':
					roman_int = roman_int + 100;
					break;
				case 'D':
					roman_int = roman_int + 500;
					break;
				case 'M':
					roman_int = roman_int + 1000;
					break;
				default:
					System.out.println("default");
					break;
			}

			//从第二个字符，开始判断那些特殊的字符
			if (i != 0) {
				if (((s.charAt(i) == 'V') || (s.charAt(i) == 'X')) && (s.charAt(i - 1) == 'I'))
					roman_int = roman_int - 1 * 2;
				if (((s.charAt(i) == 'L') || (s.charAt(i) == 'C')) && (s.charAt(i - 1) == 'X'))
					roman_int = roman_int - 10 * 2;
				if (((s.charAt(i) == 'D') || (s.charAt(i) == 'M')) && (s.charAt(i - 1) == 'C'))
					roman_int = roman_int - 100 * 2;
			}
		}
		return roman_int;
	}
}
