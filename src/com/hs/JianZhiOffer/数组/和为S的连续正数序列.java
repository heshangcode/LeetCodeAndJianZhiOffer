package com.hs.JianZhiOffer.数组;

import java.util.ArrayList;

/**
 * 输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
 * <p>
 * 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、4～6和7～8。
 * <p>
 * 样例
 * 输入：15
 * <p>
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * 思路：双指针法，初始化i = 1，j = 2，i+j《sum，给加入3， 如果》 去掉1
 *
 * @Author heshang.ink
 * @Date 2019/10/13 9:46
 */
public class 和为S的连续正数序列 {
	public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (sum <= 2) {
			return res;
		}
		int l = 1, r = 2;
		while (l < r) {
			//等差求和公式，(a0 + an)*n /2
			int s = (l + r) * (r - l + 1) / 2;
			//满足和，则遍历加入list
			if (s == sum) {
				ArrayList<Integer> list = new ArrayList<>();
				for (int k = l; k <= r; k++) {
					list.add(k);
				}
				res.add(list);
				l++;
			} else if (s < sum) {
				//窗口和小于sum，右移
				r++;
			} else {
				//窗口和大于sum，左移
				l++;
			}
		}
		return res;
	}

	public ArrayList<ArrayList<Integer>> findContinuousSequence2(int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (sum <= 2) {
			return res;
		}
		//这里sum /2 是，因为任何一个数最大的连续和只能在他一半的前面，所以那个l的边界情况l<=sum/2
		for (int l = 1, r = 1,s = 1; l <= sum / 2; l++) {
			while (s < sum) {
				r++;
				s += r;
			}
			if (s == sum && r > l) {
				ArrayList<Integer> list = new ArrayList<>();
				for (int k = l; k <= r; k++) {
					list.add(k);
				}
				res.add(list);
			}
			//这里是为了把左边的值移掉
			s -= l;
		}
		return res;
	}

}
