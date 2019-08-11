package com.hs.LeetCode;

import java.util.HashMap;

/**
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * <p>
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [[0,0],[1,0],[2,0]]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-boomerangs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 遍历每个点，看其他点到这个点的距离相同的有多少，
 * 比如 到i点距离为2的有3个点 那三元组合就是 3 x （3-1）
 *
 * @Author heshang.ink
 * @Date 2019/8/10 10:43
 */
public class LeetCode447回旋镖的数量 {
	public int numberOfBoomerangs(int[][] points) {
		//依次把每个点作为i点
		int res = 0;
		for (int i = 0; i < points.length; i++) {
			// record中存储 点i 到所有其他点的距离出现的频次
			HashMap<Integer, Integer> record = new HashMap<>();
			for (int j = 0; j < points.length; j++) {
				//去掉自身
				if (j != i) {
					// 计算距离时不进行开根运算, 以保证精度
					int dis = dis(points[i], points[j]);
					if (record.containsKey(dis)) {
						record.put(dis, record.get(dis) + 1);
					} else {
						record.put(dis, 1);
					}
				}
			}
			for (Integer dis : record.keySet()) {
				res += record.get(dis) * (record.get(dis) - 1);
			}
		}
		return res;
	}

	private int dis(int[] p1, int[] p2) {
		return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
	}

	public static void main(String[] args) {

	}
}
