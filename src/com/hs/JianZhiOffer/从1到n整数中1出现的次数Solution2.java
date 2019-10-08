package com.hs.JianZhiOffer;

/**
 * 输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如输入12，从1到12这些整数中包含“1”的数字有1，10，11和12，其中“1”一共出现了5次。
 * <p>
 * 样例
 * 输入： 12
 * 输出： 5
 * <p>
 * 按位比较
 * 设数字为abcdef，当前位数为c位，
 *         c位1的个数即为高位个数+低位个数
 *         高位范围为 00 ~ ab-1 ：
 *             有 ab*1000 个(因为c在千位)
 *         低位分为三种情况：
 *             c = 0 ,有 0 个
 *             c = 1 ，有 def + 1 个
 *             c > 1 , 有 1000 个 (因为c在千位)
 *         依次遍历每一位数相加，即为总共1的个数
 * 比如231043
 * @Author heshang.ink
 * @Date 2019/10/7 8:12
 */
public class 从1到n整数中1出现的次数Solution2 {
	public int NumberOf1Between1AndN_Solution(int n) {
		int res = 0;
		int ab = n;
		int def = 0;
		// 代表第几位，初始是个位，然后十位，百位...
		int digit = 1;
		while (ab > 0) {
			//c位每次从个位开始
			int c = ab % 10;
			ab /= 10;
			// ab x 位数代表多少个1，比如 101 10 后面是个位所以是 10 * 10
			// 计算高位的1
			res += ab * digit;

			// 计算低位的1
			if (c > 1) {
				res += digit;
			} else if (c == 1) {
				res += def + 1;
			}
			//低位的值要变换
			def += c * digit;
			//每一次位数得变换一下，每次都进位，所以 * 10
			digit *= 10;

		}
		return res;
	}
}
