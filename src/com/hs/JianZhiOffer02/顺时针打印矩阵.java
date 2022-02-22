package com.hs.JianZhiOffer02;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/13 16:43
 * version: 1.0
 */
public class 顺时针打印矩阵 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        int[] ans = new int[(r + 1) * (b + 1)];
        int x = 0;
        while (true) {
            for (int i = l; i <= r; i++) {
                ans[x++] = matrix[t][i];
            }
            if (++t > b) {
                break;
            }

            for (int i = t; i <= b; i++) {
                ans[x++] = matrix[i][r];
            }
            if (--r < l) {
                break;
            }

            for (int i = r; i >= l; i--) {
                ans[x++] = matrix[b][i];
            }

            if (--b < t) {
                break;
            }

            for (int i = b; i >= t; i--) {
                ans[x++] = matrix[i][l];
            }
            if (++l > r) {
                break;
            }
        }
        return ans;
    }
}
