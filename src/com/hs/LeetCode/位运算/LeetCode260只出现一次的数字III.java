package com.hs.LeetCode.位运算;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/10/12 21:45
 */
public class LeetCode260只出现一次的数字III {
	public int[] singleNumber(int[] nums) {
		//异或和
		int sum = 0;
		for (int x : nums) {
			sum ^= x;
		}
		//找到异或和结果为1的第几位
		int k = 0;
		while ((sum >> k & 1) != 1) {
			k++;
		}
		int first = 0;
		for (int x : nums) {
			if ((x >> k & 1) == 1) {
				first ^= x;
			}
		}
		return new int[]{first, sum ^ first};
	}
}
