package com.hs.LeetCode01.回溯算法.二维回溯;

/**
 * https://leetcode-cn.com/problems/number-of-islands/solution/
 * 思路1：DFS（但不全是回溯，因为最后没有恢复，叫floodfill）
 * 思路2：BFS
 * 思路3：并查集
 * https://leetcode-cn.com/problems/number-of-islands/solution/dfs-bfs-bing-cha-ji-python-dai-ma-java-dai-ma-by-l/
 * https://www.youtube.com/watch?v=XSmgFKe-XYU
 *
 * @Author heshang.ink
 * @Date 2019/9/1 18:29
 */
public class LeetCode200岛屿数量 {
	//控制方向
	int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	int m, n;
	boolean[][] isVisited;

	public int numIslands(char[][] grid) {
		m = grid.length;
		if (m == 0) {
			return 0;
		}
		n = grid[0].length;

		isVisited = new boolean[m][n];

		int count = 0;
		//遍历水域
		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				// 如果是岛屿中的一个点，并且没有被访问过
				// 就进行深度优先遍历
				if (grid[x][y] == '1' && !isVisited[x][y]) {
					dfs(grid, x, y);
					System.out.println(count);
					count++;
				}
			}
		}
		return count;
	}
	// 从坐标为 (x,y) 的点开始进行深度优先遍历
	private void dfs(char[][] grid, int x, int y) {

		isVisited[x][y] = true;

		//移动方向
		for (int i = 0; i < 4; i++) {
			int newX = x + d[i][0];
			int newY = y + d[i][1];
			// 如果不越界、没有被访问过、并且还要是陆地
			if (inArea(newX, newY) && !isVisited[newX][newY] && grid[newX][newY] == '1') {
				dfs(grid, newX, newY);
			}
			//与回溯不一样的就是不需要恢复原状
			//isVisited[x][y] = false;
		}

		return;

	}

	private boolean inArea(int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n;
	}

	public static void main(String[] args) {

		char grid1[][] = {
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}
		};
		System.out.println((new LeetCode200岛屿数量()).numIslands(grid1));
		// 1

		// ---

		/*char grid2[][] = {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}
		};
		System.out.println((new LeetCode200岛屿数量()).numIslands(grid2));*/
		// 3
	}
}
