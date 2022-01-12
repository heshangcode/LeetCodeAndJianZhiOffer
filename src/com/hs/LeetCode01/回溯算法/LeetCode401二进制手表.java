package com.hs.LeetCode01.回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-watch/
 * 思路1：小时和分钟凉的灯表示为1，化为二进制，统计1的个数
 * https://leetcode-cn.com/problems/binary-watch/solution/can-kao-ge-wei-da-lao-yong-shi-pin-jiang-jie-liao-/
 * 思路2：
 * @Author heshang.ink
 * @Date 2019/8/31 14:33
 */
public class LeetCode401二进制手表 {
	List<String> res = new ArrayList<>();

	public List<String> readBinaryWatch(int num) {

		if (num < 0) {
			return res;
		}
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 60; j++) {
				if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
					res.add(String.format("%d:%02d", i, j));
				}
			}
		}
		return res;
	}
}
