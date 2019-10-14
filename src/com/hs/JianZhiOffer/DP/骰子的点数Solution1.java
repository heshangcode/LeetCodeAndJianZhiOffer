package com.hs.JianZhiOffer.DP;

/**
 * 将一个骰子投掷n次，获得的总点数为s，s的可能范围为n~6n。
 *
 * 掷出某一点数，可能有多种掷法，例如投掷2次，掷出3点，共有[1,2],[2,1]两种掷法。
 *
 * 请求出投掷n次，掷出n~6n点分别有多少种掷法。
 *
 * 样例1
 * 输入：n=1
 *
 * 输出：[1, 1, 1, 1, 1, 1]
 *
 * 解释：投掷1次，可能出现的点数为1-6，共计6种。每种点数都只有1种掷法。所以输出[1, 1, 1, 1, 1, 1]。
 * 样例2
 * 输入：n=2
 *
 * 输出：[1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1]
 *
 * 解释：投掷2次，可能出现的点数为2-12，共计11种。每种点数可能掷法数目分别为1,2,3,4,5,6,5,4,3,2,1。
 *
 *       所以输出[1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1]。
 *
 * @Author heshang.ink
 * @Date 2019/10/14 17:44
 */
public class 骰子的点数Solution1 {
	static int[] res = null;
	static int count;

	public static int[] numberOfDice(int n) {
		res = new int[6 * n - n + 1];
		for (int i = n,j=0; i <= 6 * n; i++,j++) {
			count = 0;
			dfs(n, i);
			res[j] = count;
		}
		return res;
	}

	/**
	 * n次组合数是sum的个数
	 * @param n
	 * @param sum
	 */
	private static void dfs(int n, int sum) {

		if (sum == 0&&n==0) {
			count++;
			return;
		}
		if (n == 0)
			return;
		if (sum < 0)
			return;
		for (int i = 1; i <= 6; i++) {
			dfs(n - 1, sum - i);
			if (sum - i <= 0)
				break;
		}
	}

}
