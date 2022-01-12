package com.hs.LeetCode01.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author heshang.ink
 * @Date 2019/10/3 9:32
 */
public class LeetCode54螺旋矩阵顺时针打印矩阵 {
	public List<Integer> spiralOrder(int[][] matrix) {
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
