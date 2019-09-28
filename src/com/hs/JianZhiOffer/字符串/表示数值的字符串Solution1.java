package com.hs.JianZhiOffer.字符串;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 *
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * 注意:
 *
 * 小数可以没有整数部分，例如.123等于0.123；
 * 小数点后面可以没有数字，例如233.等于233.0；
 * 小数点前面和后面可以有数字，例如233.666;
 * 当e或E前面没有数字时，整个字符串不能表示数字，例如.e1、e1；
 * 当e或E后面没有整数时，整个字符串不能表示数字，例如12e、12e+5.4;
 * 样例：
 * 输入: "0"
 *
 * 输出: true
 *
 * @Author heshang.ink
 * @Date 2019/9/28 20:23
 */
public class 表示数值的字符串Solution1 {

	private int index = 0;

	public boolean isNumeric(char[] str) {
		if (str.length==0) return false;
		boolean flag = scanInteger(str);

		// 如果出现'.'，接下来是数字的小数部分
		if (index < str.length && str[index] == '.') {
			index++;
			// 下面一行代码用||的原因：
			// 1. 小数可以没有整数部分，例如.123等于0.123；
			// 2. 小数点后面可以没有数字，例如233.等于233.0；
			// 3. 当然小数点前面和后面可以有数字，例如233.666
			flag = scanUnsignedInteger(str) || flag;
		}

		// 如果出现'e'或者'E'，接下来跟着的是数字的指数部分
		if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
			index++;
			// 下面一行代码用&&的原因：
			// 1. 当e或E前面没有数字时，整个字符串不能表示数字，例如.e1、e1；
			// 2. 当e或E后面没有整数时，整个字符串不能表示数字，例如12e、12e+5.4
			flag = flag && scanInteger(str);
		}
		return flag && index == str.length;
	}

	private boolean scanInteger(char[] str) {
		if (index < str.length && (str[index] == '+' || str[index] == '-') )
			index++;
		return scanUnsignedInteger(str);
	}
	private boolean scanUnsignedInteger(char[] str) {
		int start = index;
		while (index < str.length && str[index] >= '0' && str[index] <= '9')
			index++;
		// 当str中存在若干0-9的数字时，返回true
		return start < index;
	}
}
