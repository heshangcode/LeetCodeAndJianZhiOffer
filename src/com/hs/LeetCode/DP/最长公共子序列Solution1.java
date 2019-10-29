package com.hs.LeetCode.DP;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/7/3 11:16
 */
public class 最长公共子序列Solution1 {
	/**
	 * 序列A[0,n]和B[0,m]
	 * 递归版
	 *
	 * @param A
	 * @param B
	 * @return
	 */
	public int lcs(String A, String B) {
		if (A.length() == 0 || B.length() == 0) {
			return 0;
		}

		if (A.charAt(A.length() - 1) == B.charAt(B.length() - 1)) {
			//如果A[n] == A[m]
			return 1 + lcs(A.substring(0, A.length() - 1), B.substring(0, B.length() - 1));
		} else {
			//如果A[n] != A[m]，比较n-1和m，n和m-1的最大值
			return Math.max(lcs(A.substring(0, A.length() - 1), B.substring(0, B.length())), lcs(A.substring(0,
					A.length()), B.substring(0, B.length() - 1)));
		}
	}
}
