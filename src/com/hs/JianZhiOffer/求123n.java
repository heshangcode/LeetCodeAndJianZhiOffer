package com.hs.JianZhiOffer;

/**
 * 求1+2+…+n,要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * 样例
 * 输入：10
 * <p>
 * 输出：55
 *
 * @Author heshang.ink
 * @Date 2019/10/14 21:39
 */
public class 求123n {
	public int getSum(int n) {
		int res = n;
		//正常操作
		/*if (n > 0) {
			res += getSum(n - 1);
		}*/
		//改写
		boolean t = n != 0 && ((res += getSum(n - 1)) != 0);
		return res;

	}
}
