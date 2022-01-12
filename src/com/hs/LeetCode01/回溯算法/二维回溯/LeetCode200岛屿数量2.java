package com.hs.LeetCode01.回溯算法.二维回溯;

import java.util.LinkedList;

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
public class LeetCode200岛屿数量2 {
	//控制方向
	int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	//BFS解决
	boolean[][] isVisited;
	int m;
	int n;

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
				// 从坐标为 (x,y) 的点开始进行广度优先遍历
				if (!isVisited[x][y] && grid[x][y] == '1') {
					count++;

					LinkedList<Integer> queue = new LinkedList<>();
					// 小技巧：把坐标转换为一个数字
					// 否则，得用一个数组存
					queue.add(x * n + y);

					// 注意：这里要标记上已经访问过
					isVisited[x][y] = true;
					while (!queue.isEmpty()) {
						int cur = queue.removeFirst();
						int curX = cur / n;
						int curY = cur % n;
						// 得到 4 个方向的坐标
						for (int i = 0; i < 4; i++) {
							int newX = curX + d[i][0];
							int newY = curY + d[i][1];
							// 如果不越界、没有被访问过、并且还要是陆地，我就继续放入队列，放入队列的同时，要记得标记已经访问过
							if (inArea(newX, newY) && grid[newX][newY] == '1' && !isVisited[newX][newY]) {
								queue.addLast(newX * n + newY);
								// 【特别注意】在放入队列以后，要马上标记成已经访问过，语义也是十分清楚的：反正只要进入了队列，你迟早都会遍历到它
								// 而不是在出队列的时候再标记
								// 【特别注意】如果是出队列的时候再标记，会造成很多重复的结点进入队列，造成重复的操作，这句话如果你没有写对地方，代码会严重超时的
								isVisited[newX][newY] = true;
							}
						}

					}
				}

			}
		}
		return count;
	}
	private boolean inArea(int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n;
	}

}
