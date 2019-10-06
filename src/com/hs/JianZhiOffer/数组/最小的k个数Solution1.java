package com.hs.JianZhiOffer.数组;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入n个整数，找出其中最小的k个数。
 *
 * 注意：
 *
 * 数据保证k一定小于等于输入数组的长度;
 * 输出数组内元素请按从小到大顺序排序;
 * 样例
 * 输入：[1,2,3,4,5,6,7,8] , k=4
 *
 * 输出：[1,2,3,4]
 * 思路1：排序然后输出就ok
 *
 * @Author heshang.ink
 * @Date 2019/10/6 10:35
 */
public class 最小的k个数Solution1 {
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> res = new ArrayList<>();
		if (k > input.length) {
			return res;
		}
		Arrays.sort(input);
		for (int i = 0; i < k; i++) {
			res.add(input[i]);
		}
		return res;
	}
}
