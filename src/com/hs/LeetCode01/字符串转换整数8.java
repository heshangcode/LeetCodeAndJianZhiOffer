package com.hs.LeetCode01;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * <p>
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <p>
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * <p>
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * <p>
 * 说明：
 * <p>
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author heshang.ink
 * @Date 2019/6/28 16:52
 */
public class 字符串转换整数8 {
	public int myAtoi(String str) {
		/**
		 *思路：首先找出数字，然后判断是否溢出
		 */
		str = str.trim();
		if (str.length() == 0) {
			return 0;
		}
		int ret = 0, flag = 1;

		for (int i = 0; i < str.length(); i++) {
			if (i == 0) {
				if (str.charAt(i) == '-') {
					flag = -1;
				} else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
					ret += str.charAt(i) - '0';
				} else if (str.charAt(i) != '+') {
					//第一个字符不是 - ，也不是数字
					return 0;
				}
			} else {
				if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
					ret = ret * 10 + str.charAt(i) - '0';
				} else {
					break;
				}

			}
		}
		ret = flag * ret;

		//判断溢出
		int pop = ret % 10;
		int x = ret / 10;
		if (x > Integer.MAX_VALUE / 10 || (x == Integer.MAX_VALUE / 10 && pop > 7)) return Integer.MAX_VALUE;
		if (x < Integer.MIN_VALUE / 10 || (x == Integer.MIN_VALUE / 10 && pop < -8)) return Integer.MIN_VALUE;
		return ret;
	}
}
