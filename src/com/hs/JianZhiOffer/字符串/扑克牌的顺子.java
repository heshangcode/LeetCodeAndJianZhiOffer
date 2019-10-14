package com.hs.JianZhiOffer.字符串;

import java.util.Arrays;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * <p>
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，大小王可以看做任意数字。
 * <p>
 * 为了方便，大小王均以0来表示，并且假设这副牌中大小王均有两张。
 * <p>
 * 样例1
 * 输入：[8,9,10,11,12]
 * <p>
 * 输出：true
 * 样例2
 * 输入：[0,8,9,11,12]
 * <p>
 * 输出：true
 *
 * @Author heshang.ink
 * @Date 2019/10/14 18:08
 */
public class 扑克牌的顺子 {
	public boolean isContinuous(int[] numbers) {
		if (numbers.length < 5) {
			return false;
		}
		Arrays.sort(numbers);
		//统计0的数量
		int zero = 0;
		for (int x : numbers) {
			if (x == 0) {
				zero++;
			}
		}
		//使用0补充不连续的顺子
		for (int i = zero; i < numbers.length - 1; i++) {
			//如果数字重复了
			if (numbers[i] == numbers[i + 1]) {
				return false;
			}
			//判断两个数字之间差多少，然后用0补充不连续的
			zero -= numbers[i + 1] - numbers[i] - 1;

		}
		return zero >= 0;

	}

}
