package com.hs.LeetCode.DP;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/7/3 11:16
 */
public class 最长公共子序列 {
	/**
	 * 序列A[0,n]和B[0,m]
	 * 递归版
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
			return Math.max(lcs(A.substring(0, A.length() - 1), B.substring(0, B.length())), lcs(A.substring(0, A.length()), B.substring(0, B.length() - 1)));
		}
	}

	public int findLCS(String A, int n, String B, int m) {
		int[][] nums = new int[n + 1][m + 1];
		//这里是直接把nums[0][0]默认为0
		for (int i = 1; i < nums.length; i++) {
			for (int j = 1; j < nums[i].length; j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					//如果两串这个串相等，则左上角 + 1
					nums[i][j] = nums[i - 1][j - 1] + 1;
				} else {
					//不相同，取左边和上面最大值
					nums[i][j] = Math.max(nums[i][j - 1],nums[i - 1][j]);
				}
			}
		}
		return nums[n][m];


	}

	public static void main(String[] args) {
		int lcs = new 最长公共子序列().lcs("abcdda", "adcda");
		System.out.println(lcs);

		int lcs1 = new 最长公共子序列().findLCS("abcdda",6,"adcda",5);
		System.out.println(lcs1);
	}
}
