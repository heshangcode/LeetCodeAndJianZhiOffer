package com.hs.JianZhiOffer02;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/12 18:04
 * version: 1.0
 */
public class 二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int nums = matrix[row][column];
            if (nums > target) {
                column--;
            } else if (nums < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }
}
