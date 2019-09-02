package com.hs.LeetCode.回溯算法.二维回溯;

/**
 * https://leetcode-cn.com/problems/surrounded-regions/solution/
 * 思路：跟普通的二维回溯有点不一样，把思路逆序想一下
 * 从边界为O的开始，连通的改为*，其他的就可以全部改为X，然后再把*改为O
 * https://leetcode-cn.com/problems/surrounded-regions/solution/bfsdi-gui-dfsfei-di-gui-dfsbing-cha-ji-by-ac_pipe/
 *
 * @Author heshang.ink
 * @Date 2019/9/2 18:23
 */
public class LeetCode130被围绕的区域 {

	int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	int m, n;

	public void solve(char[][] board) {
		m = board.length;
		if (m == 0) {
			return;
		}
		n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				//这个点是边界
				// 从边缘o开始搜索
				boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
				if (isEdge && board[i][j] == 'O') {
					dfs(board, i, j);
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if (board[i][j] == '*') {
					board[i][j] = 'O';
				}
			}
		}

	}

	private void dfs(char[][] board, int x, int y) {

		board[x][y] = '*';
		for (int i = 0; i < 4; i++) {
			int newX = x + d[i][0];
			int newY = y + d[i][1];
			//在范围内，!= '*' 表示遍历过了， == '0' 就继续dfs
			if (inArea(newX, newY) && board[newX][newY] != '*' && board[newX][newY] == 'O') {
				dfs(board, newX, newY);
			}

		}
	}

	private boolean inArea(int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n;
	}


	//简化版
	private void dfs2(char[][] board, int x, int y) {
		if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] == '*' || board[x][y] != 'O') {
			return;
		}
		for (int i = 0; i < 4; i++) {

			dfs2(board, x + d[i][0], x + d[i][1]);
		}

	}
}
