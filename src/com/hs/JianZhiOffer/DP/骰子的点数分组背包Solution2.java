package com.hs.JianZhiOffer.DP;

/**
 * 将一个骰子投掷n次，获得的总点数为s，s的可能范围为n~6n。
 * <p>
 * 掷出某一点数，可能有多种掷法，例如投掷2次，掷出3点，共有[1,2],[2,1]两种掷法。
 * <p>
 * 请求出投掷n次，掷出n~6n点分别有多少种掷法。
 * <p>
 * 样例1
 * 输入：n=1
 * <p>
 * 输出：[1, 1, 1, 1, 1, 1]
 * <p>
 * 解释：投掷1次，可能出现的点数为1-6，共计6种。每种点数都只有1种掷法。所以输出[1, 1, 1, 1, 1, 1]。
 * 样例2
 * 输入：n=2
 * <p>
 * 输出：[1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1]
 * <p>
 * 解释：投掷2次，可能出现的点数为2-12，共计11种。每种点数可能掷法数目分别为1,2,3,4,5,6,5,4,3,2,1。
 * <p>
 * 所以输出[1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1]。
 * <p>
 * 思路：
 * 分组背包问题
 * <p>
 * 状态表示f[i][j]：表示前i次总和是j的方案数
 * 状态转化：f[i][j] += f[i-1][i - k]
 *
 * @Author heshang.ink
 * @Date 2019/10/14 17:44
 */
public class 骰子的点数分组背包Solution2 {

	public static int[] numberOfDice(int n) {
		int[] res = new int[6 * n - n + 1];
		//状态表示 f[i][j] 前i次，总和为j的次数
		int[][] f = new int[n + 1][6 * n + 1];
		f[0][0] = 1;
		for (int i = 1; i <= n; i++) {
			//第i次
			for (int j = 1; j <= i * 6; j++) {
				//总和为j
				for (int k = 1; k <= Math.min(j, 6); k++) {
					//这里是枚举是出现的点数，k可能为1-6的点
					f[i][j] += f[i - 1][j - k];
				}
			}
		}
		for (int i = n, j = 0; i <= 6 * n; i++, j++) {
			res[j] = f[n][i];
		}
		return res;
	}

}
