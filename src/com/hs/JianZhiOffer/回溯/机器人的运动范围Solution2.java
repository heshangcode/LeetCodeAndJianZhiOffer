package com.hs.JianZhiOffer.回溯;

import java.util.LinkedList;

/**
 * BFS解决 可能没有Pair包，就自己定义一个
 *
 * 地上有一个 m 行和 n 列的方格，横纵坐标范围分别是 0∼m−1 和 0∼n−1。
 *
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格。
 *
 * 但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
 *
 * 请问该机器人能够达到多少个格子？
 *
 * 样例1
 * 输入：k=7, m=4, n=5
 *
 * 输出：20
 * 样例2
 * 输入：k=18, m=40, n=40
 *
 * 输出：1484
 *
 * 解释：当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 *       但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 *
 * @Author heshang.ink
 * @Date 2019/9/25 14:35
 */
class Node{
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class 机器人的运动范围Solution2 {
	//方向
	int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	int m ;
	int n;
	public int movingCount(int target, int rows, int cols) {
		m = rows;
		n = cols;
		boolean[][] visited = new boolean[rows][cols];
		int[][] nums = new int[rows][cols];
		if (rows == 0 || cols == 0) {
			return 0;
		}
		int res = 0;

		LinkedList<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0));
		while (!queue.isEmpty()) {
			Node pop = queue.pop();
			int x = pop.x;
			int y = pop.y;
			if (sum(x) + sum(y) <= target && !visited[x][y]) {
				res++;
				visited[x][y] = true;
				for (int i = 0; i < 4; i++) {
					int newX = x + d[i][0];
					int newY = y + d[i][1];
					if (inArea(newX, newY) && !visited[newX][newY]) {
						queue.add(new Node(newX, newY));
					}
				}
			}
		}
		/*LinkedList<Pair<Integer,Integer>> queue = new LinkedList<>();
		queue.add(new Pair<>(0, 0));
		queue.add(new Node(0, 0));
		while (!queue.isEmpty()) {
			Pair<Integer, Integer> pop = queue.pop();
			if (sum(pop.getKey()) + sum(pop.getValue()) <= target && !visited[pop.getKey()][pop.getValue()]) {
				res++;
				visited[pop.getKey()][pop.getValue()] = true;
				//上下移动方向
				for (int i = 0; i < 4; i++) {
					int newX = pop.getKey() + d[i][0];
					int newY = pop.getValue() + d[i][1];
					if (inArea(newX, newY) && !visited[newX][newY]) {
						queue.add(new Pair<>(newX, newY));
					}
				}
			}
		}*/
		return res;
	}

	private int sum(int x) {
		int res = 0;
		while (x > 0) {
			res += x % 10;
			x /= 10;
		}
		return res;
	}

	private boolean inArea(int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n;
	}

	public static void main(String[] args) {
		System.out.println(new 机器人的运动范围Solution2().movingCount(5, 10, 10));
	}
}
