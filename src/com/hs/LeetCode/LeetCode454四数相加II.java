package com.hs.LeetCode;

import java.util.HashMap;

/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 * <p>
 * 例如:
 * <p>
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路：1.如果暴力，500^4 肯定超时
 * 2.如果把D放入n^3，也会超时
 * 3. 可以把 C + D的和放入一个查找表
 *
 * @Author heshang.ink
 * @Date 2019/8/9 17:57
 */
public class LeetCode454四数相加II {

	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		if (A == null || B == null || C == null || D == null) {
			throw new IllegalArgumentException("Illegal argument");
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		//因为 C + D的和不确定大小，不能用数组
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				int sum = C[i] + D[j];
				if (!map.containsKey(sum)) {
					map.put(sum, 1);
				} else {
					map.put(sum, map.get(sum) + 1);
				}
			}
		}
		int res = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if (map.containsKey(0 - A[i] - B[j])) {
					res += map.get(0 - A[i] - B[j]);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {

		int[] a = {1, 2};
		int[] b = {-2, -1};
		int[] c = {-1, 2};
		int[] d = {0, 2};
		System.out.println(fourSumCount(a, b, c, d));
	}
}
