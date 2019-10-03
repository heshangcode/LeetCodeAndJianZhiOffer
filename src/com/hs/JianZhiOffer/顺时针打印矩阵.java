package com.hs.JianZhiOffer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 样例
 * 输入：
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 *
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @Author heshang.ink
 * @Date 2019/10/3 9:28
 */
public class 顺时针打印矩阵 {
	public ArrayList<Integer> printMatrix(int [][] matrix) {
		ArrayList<Integer> res = new ArrayList<>();
		//方向
		int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		int n = matrix.length;
		if (n == 0) {
			return res;
		}
		int m = matrix[0].length;
		// 判断是否被访问
		boolean[][] visited = new boolean[n][m];
		int x = 0, y = 0, di = 0;
		for (int i = 0; i < n * m; i++) {
			visited[x][y] = true;
			res.add(matrix[x][y]);
			int newX = x + d[di][0];
			int newY = y + d[di][1];
			//处理边界
			if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY]) {
				//在边界里
				x = newX;
				y = newY;
			} else {
				//不在边界里，改变方向
				di = (di + 1) % 4;
				x = x + d[di][0];
				y = y + d[di][1];
			}
		}
		return res;
	}
}
