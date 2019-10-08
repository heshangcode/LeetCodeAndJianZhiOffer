package com.hs.JianZhiOffer.数组;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 例如输入数组[3, 32, 321]，则打印出这3个数字能排成的最小数字321323。
 *
 * 样例
 * 输入：[3, 32, 321]
 *
 * 输出：321323
 * 注意：输出数字的格式为字符串。
 *
 * 思路：比较排序值：a < b <==>  ab < ab
 * @Author heshang.ink
 * @Date 2019/10/8 20:28
 */
public class 把数组排成最小的数 {
	public String printMinNumber(int[] nums) {
		if (nums == null || nums.length == 0 ) {
			return "";
		}
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			list.add(String.valueOf(nums[i]));
		}
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				String st1 = s1 + s2;
				String st2 = s2 + s1;
				return st1.compareTo(st2);
			}
		});
		StringBuilder s = new StringBuilder();
		for (String str : list) {
			s.append(str);
		}
		return s.toString();
	}
}
