package com.hs.LeetCode01.DP.背包问题;

import java.util.Scanner;

/**
 * 有一个背包，他的容量为C(Capacity)。现在有n中不同的物品，编号为0…n-1，其中每一件物品的重量为w(i)，价值为v(i)。问可以向这个背包中盛放哪些物品，使得在不超过背包容量的基础上，物品的总价值最大。
 * <p>
 * <p>
 * 01背包问题 - AcWing题库
 * https://www.acwing.com/problem/content/2/
 *
 * @Author heshang.ink
 * @Date 2019/9/12 20:32
 */
public class 经典DP01背包问题 {
	// memo[i][c] 表示使用索引为[0...i]的这些元素,是否可以完全填充一个容量为c的背包
	private int[][] memo;

	/**
	 * 背包问题
	 * 记忆化搜索
	 * 时间复杂度: O(n * C) 其中n为物品个数; C为背包容积
	 * 空间复杂度: O(n * C)
	 *
	 * @param w
	 * @param v
	 * @param C
	 * @return
	 */
	public int knapsack01(int[] w, int[] v, int C) {
		if (w == null || v == null || w.length != v.length) {
			throw new IllegalArgumentException("Invalid w or v");
		}

		if (C < 0) {
			throw new IllegalArgumentException("C must be greater or equal to zero.");
		}

		int n = v.length;
		if (n == 0 || C == 0) {
			return 0;
		}
		memo = new int[n][C + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= C; j++) {
				memo[i][j] = -1;
			}
		}
		return bestValue(w, v, n - 1, C);
	}

	// 用 [0...index]的物品,填充容积为c的背包的最大价值
	private int bestValue(int[] w, int[] v, int index, int c) {
		if (c <= 0 || index < 0) {
			return 0;
		}

		if (memo[index][c] != -1) {
			return memo[index][c];
		}
		//这个物品不装
		int res = bestValue(w, v, index - 1, c);
		//这个物品装
		if (w[index] <= c) {
			res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));
		}

		return memo[index][c] = res;
	}

	/**
	 * 自底向上的解法
	 * <p>
	 * 定义一个二阶矩阵dp[N+1][V+1],
	 * 这里之所以要N+1和V+1，是因为第0行表示只能选择第0个物品的时候，即没有物品的时候
	 * 第0列表示背包的体积为0的时候，即不能装任何东西的时候
	 * <p>
	 * dp[i][j]表示在 只能选择前i个物品，背包容量为j的情况下，背包中物品的最大价值
	 * 对于dp[i][j]有两种情况：
	 * 1. 不选择当前的第i件物品/第i件物品比背包容量要大，则dp[i][j] = dp[i-1][j]
	 * 2. 选择当前的第i件物品（潜在要求第i件物品体积小于等于背包总容量），则能装入的物品最大价值为：
	 * 当前物品的价值 加上 背包剩余容量在只能选前i-1件物品的情况下的最大价值
	 * dp[i][j] = dp[i-1][j-v[i]] + w[i]
	 * dp[i][j]在两种情况中选择比较大的情况作为当前的最优解；
	 * 即：
	 * if(j >= v[i]):
	 * dp[i][j] = max(dp[i-1][j], dp[i-1][j-v[i]] + w[i])
	 * else:
	 * dp[i][j] = dp[i-1][j]
	 *
	 * @param w
	 * @param v
	 * @param C
	 * @return
	 */
	public int knapsack012(int[] w, int[] v, int C) {
		int[][] dp = new int[w.length][C + 1];
		//初始化
		for (int i = 0; i <= C; i++) {
			dp[0][i] = (i >= w[0] ? v[0] : 0);
		}
		for (int i = 1; i < w.length; i++) {
			for (int j = 0; j <= C; j++) {
				if (j >= w[i]) {
					dp[i][j] = Math.max(dp[i - 1][j], v[i] + dp[i - 1][j - w[i]]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[w.length - 1][C];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();

		int[] w = new int[n];
		int[] v = new int[n];
		for (int i = 0; i < n; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		System.out.println(new 经典DP01背包问题().knapsack012(w, v, c));

	}
}
