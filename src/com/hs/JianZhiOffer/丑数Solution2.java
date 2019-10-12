package com.hs.JianZhiOffer;

/**
 * 我们把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * <p>
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * <p>
 * 求第n个丑数的值。
 * <p>
 * 样例
 * 输入：5
 * <p>
 * 输出：5
 * 注意：习惯上我们把1当做第一个丑数。
 * <p>
 * 思路：3个数组，分别放i * 2 i * 3 i * 5的值，然后3路归并进去比较排序
 *
 * @Author heshang.ink
 * @Date 2019/10/9 11:41
 */
public class 丑数Solution2 {
	public int GetUglyNumber_Solution(int index) {
		if (index <= 0) {
			return 0;
		}
		int p2 = 0, p3 = 0, p5 = 0; //初始化三个指向潜在成为最小丑数的位置
		int[] res = new int[index];
		res[0] = 1;
		for (int i = 1; i < index; i++) {
			int t = Math.min(res[p2] * 2, Math.min(res[p3] * 3, res[p5] * 5));
			res[i] = t;
			if (res[p2] * 2 == t) {
				p2++;
			}
			if (res[p3] * 3 == t) {
				p3++;
			}
			if (res[p5] * 5 == t) {
				p5++;
			}
		}
		return res[index - 1];
	}

	public static void main(String[] args) {
		System.out.println(new 丑数Solution2().GetUglyNumber_Solution(1000));
	}

}
