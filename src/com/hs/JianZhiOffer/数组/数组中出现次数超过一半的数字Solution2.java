package com.hs.JianZhiOffer.数组;

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
 * 思路2:
 * 一个是current 用来临时存储数组中的数据
 * 一个是count 用来存储某个数字出现的次数
 * 开始时current存储数组中的第一个数,count为0，遍历数组，如果数组出现的数与current相等，则count加1，否则就减1，如果count为0，就把当前数组中的数赋给current,
 * 因为指定的数出现的次数大于数组长度的一半，count++与count–相抵消之后，最后count的值是大于等于1的，current中存的那个数就是出现最多的那个数。
 *
 * @Author heshang.ink
 * @Date 2019/10/6 10:00
 */
public class 数组中出现次数超过一半的数字Solution2 {
	public int MoreThanHalfNum_Solution(int[] array) {
		//这个方法使用于一定存在这个数字
		/*int count = 0;
		int val = 0;
		for (int num : array) {
			if (count == 0) {
				val = num;
				count = 1;
			} else {
				if (num == val) {
					count++;
				} else {
					count--;
				}
			}
		}
		return val;*/
		int count = 0;
		int val = 0;
		for (int num : array) {
			if (count == 0) {
				val = num;
				count = 1;
			} else {
				if (num == val) {
					count++;
				} else {
					count--;
				}
			}
		}
		// 因为并不是说的必须存在这个数字，就需要再判断一下
		int res = 0;
		for (int num : array) {
			if (num == val) {
				res++;
			}
		}
		return res > array.length / 2 ? val : 0;
	}


}
