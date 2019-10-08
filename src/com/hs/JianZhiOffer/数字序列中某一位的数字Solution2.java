package com.hs.JianZhiOffer;

/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * <p>
 * 在这个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。
 * <p>
 * 请写一个函数求任意位对应的数字。
 * <p>
 * 样例
 * 输入：13
 * <p>
 * 输出：1
 * <p>
 * 思路：
 * 1.确定是几位数 n - 10 - 90(10-99,90个数) *2-900*3
 * 2.确定是几位数里的第几个数  比如2300 800 - 10 - 90*2 = 610，610 / 2 =305位，即为10+90+305 这个数里
 * 3.属于那个数的第几位
 *
 * @Author heshang.ink
 * @Date 2019/10/7 8:57
 */
public class 数字序列中某一位的数字Solution2 {
	public int digitAtIndex(int n) {
		int i = 1;
		long count = 9;
		int start = 1;//这里以1开始不用考虑边界问题
		//首先确定这个数是几位数
		while (n > i * count) {
			n -= i * count;
			i++;
			count *= 10;
			start *= 10;
		}
		//确定具体的值
		int target = start + (n - 1) / i;
		//利用字符串确定在这个数上的第几位数
		String s = Integer.toString(target);
		//用于以无符号二进制形式表示 char值的字节数。
		return Integer.parseInt(String.valueOf(s.charAt((n - 1) % i)));
	}

}
