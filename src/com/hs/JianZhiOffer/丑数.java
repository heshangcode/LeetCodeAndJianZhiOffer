package com.hs.JianZhiOffer;

import java.util.ArrayList;

/**
 * 我们把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 *
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 *
 * 求第n个丑数的值。
 *
 * 样例
 * 输入：5
 *
 * 输出：5
 * 注意：习惯上我们把1当做第一个丑数。
 *
 * 思路：遍历到1000000里的丑数放进一个list里，判断满足第几个丑数
 * @Author heshang.ink
 * @Date 2019/10/9 11:41
 */
public class 丑数 {
	public int GetUglyNumber_Solution(int index) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		if (index == 1) {
			return 1;
		}
		for (int i = 1; i <= 100000000; i++) {
			if (isUglyNumber(i)){
				list.add(i);
			}
			if (list.size() == index) {
				return i;
			}
		}
		return -1;
	}

	private boolean isUglyNumber(int i) {
		while (i % 2 == 0) {
			i /= 2;
		}
		while (i % 3 == 0) {
			i /= 3;
		}
		while (i % 5 == 0) {
			i /= 5;
		}
		return i == 1 ? true : false;
	}
}
