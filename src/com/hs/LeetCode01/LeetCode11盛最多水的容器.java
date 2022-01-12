package com.hs.LeetCode01;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路：对撞指针，左右双指针，maxArea = 高度低 x 两个指针之间的距离
 * 所以就是为了把低高度移向高的方向
 *
 * @Author heshang.ink
 * @Date 2019/7/29 20:16
 */
public class LeetCode11盛最多水的容器 {
	public int maxArea(int[] height) {
		if (height.length == 0) {
			return 0;
		}
		int maxArea = 0;
		int l = 0, r = height.length - 1;
		while (l < r) {
			maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}
		return maxArea;
	}

}
