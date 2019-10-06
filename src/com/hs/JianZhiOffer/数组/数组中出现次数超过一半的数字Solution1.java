package com.hs.JianZhiOffer.数组;

import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 * 假设数组非空，并且一定存在满足条件的数字。
 * <p>
 * 思考题：
 * <p>
 * 假设要求只能使用 O(n) 的时间和额外 O(1) 的空间，该怎么做呢？
 * 样例
 * 输入：[1,2,1,1,3]
 * <p>
 * 输出：1
 * <p>
 * 思路1：遍历，然后用map存次数
 *
 * @Author heshang.ink
 * @Date 2019/10/6 10:00
 */
public class 数组中出现次数超过一半的数字Solution1 {
	public int MoreThanHalfNum_Solution(int[] array) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < array.length; i++) {
			if (!map.containsKey(array[i])) {
				map.put(array[i], 1);
			} else {
				map.put(array[i], map.get(array[i]) + 1);
			}
		}
		System.out.println(map);
		for (Integer key : map.keySet()) {
			if (map.get(key) > array.length / 2) {
				return key;
			}
		}
		return 0;
	}


}
