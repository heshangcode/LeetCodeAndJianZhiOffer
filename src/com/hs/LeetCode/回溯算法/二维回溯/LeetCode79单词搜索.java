package com.hs.LeetCode.回溯算法.二维回溯;

/**
 * https://leetcode-cn.com/problems/word-search/solution/zai-er-wei-ping-mian-shang-shi-yong-hui-su-fa-pyth/
 * 思路：典型二维回溯模板
 * x-1,y
 * x,y-1  x,y    x,y+1
 * x+1,y
 * 重点是d = {
 * {-1,0},
 * {0,1},
 * {1,0},
 * {0,-1},
 * }
 * 其实就是代表了，移动x，y坐标，上下左右移动
 * x - 1, y + 0  上
 * x + 0, y + 1  右
 * x + 1, y + 0  下
 * x + 0, y - 1  左
 * 注意考虑边界问题，会不会越界了
 *
 * @Author heshang.ink
 * @Date 2019/8/31 21:14
 */
public class LeetCode79单词搜索 {
	int m, n;
	boolean[][] visited;

	//移动的方向
	int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public boolean exist(char[][] board, String word) {
		if (word.length() == 0) {
			return true;
		}
		m = board.length;
		if (n < 0) {
			return false;
		}
		n = board[0].length;
		visited = new boolean[m][n];
		//依次枚举每一个起点
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (dfs(board, word, 0, i, j)) {
					return true;
				}
			}
		}
		return false;

	}

	/**
	 * @param board  二维数组
	 * @param word   要查找的字符
	 * @param index  寻找word[index...word.length()]
	 * @param startx 本次比较的坐标 x
	 * @param starty 本次比较的坐标 y
	 * @return
	 */
	private boolean dfs(char[][] board, String word, int index, int startx, int starty) {

		//说明已经找到了字符串的最后一个字符了
		if (index == word.length() - 1) {
			return board[startx][starty] == word.charAt(index);
		}

		//此时的坐标的字符跟字符串index的字符一样，则上下左右移动
		if (board[startx][starty] == word.charAt(index)) {
			//题中说的一个字符只能用一次，这个坐标的字符用了
			visited[startx][starty] = true;

			//选择上下左右进行移动了
			for (int i = 0; i < 4; i++) {
				int newx = startx + d[i][0];
				int newy = starty + d[i][1];
				//移动之后，然后再比较字符
				//需要判断是否越界，这个坐标的字符用过没有
				if (isArea(newx, newy) && !visited[newx][newy] && dfs(board, word, index + 1, newx, newy)) {
					return true;
				}
			}
			visited[startx][starty] = false;

		}
		return false;

	}

	// 判断这个坐标是否合法，有没有越界
	private boolean isArea(int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n;
	}

	public static void main(String args[]) {

		char[][] b1 = {{'A', 'B', 'C', 'E'},
				{'S', 'F', 'C', 'S'},
				{'A', 'D', 'E', 'E'}};

		String words[] = {"ABCCED", "SEE", "ABCB"};
		for (int i = 0; i < words.length; i++)
			if ((new LeetCode79单词搜索()).exist(b1, words[i]))
				System.out.println("found " + words[i]);
			else
				System.out.println("can not found " + words[i]);

		// ---

		char[][] b2 = {{'A'}};
		if ((new LeetCode79单词搜索()).exist(b2, "AB")) {
			System.out.println("found AB");
		} else {
			System.out.println("can not found AB");
		}
	}
}
