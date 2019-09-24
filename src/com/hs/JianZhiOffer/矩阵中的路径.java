package com.hs.JianZhiOffer;

/**
 * LeetCode 79 题
 *
 * @Author heshang.ink
 * @Date 2019/9/24 17:09
 */
public class 矩阵中的路径 {
	//方向
	int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	boolean[] visited;
	int row;
	int col;
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		row = rows;
		col = cols;
		visited = new boolean[matrix.length];
		//依次枚举每一个起点
		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < cols; y++) {
				if (dfs(matrix, str, 0, x, y)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 *
	 * @param matrix 矩阵
	 * @param str 找的字符串
	 * @param index
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean dfs(char[] matrix, char[] str, int index, int x, int y) {
		//说明已经找到了字符串的最后一个字符了
		if (index == str.length -1) {
			return matrix[x * col + y] == str[index];
		}

		//此时的坐标的字符跟字符串index的字符一样，则上下左右移动
		if (matrix[x * col + y] == str[index]) {
			//题中说的一个字符只能用一次，这个坐标的字符用了
			visited[x * col + y] = true;

			//选择上下左右进行移动比较
			for (int i = 0; i < 4; i++) {
				int newX = x + d[i][0];
				int newY = y + d[i][1];

				//移动之后，然后再比较字符
				//需要判断是否越界，这个坐标的字符用过没有
				if (newX >= 0 && newX < row && newY >= 0 && newY < col && !visited[newX * col + newY]
						&& dfs(matrix, str, index + 1, newX, newY)) {
					return true;
				}
			}

			visited[x * col + y] = false;

		}
		return false;
	}
}
