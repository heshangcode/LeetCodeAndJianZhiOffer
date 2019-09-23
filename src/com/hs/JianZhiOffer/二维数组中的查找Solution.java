package com.hs.JianZhiOffer;

/**
 * 思路1：暴力
 * 思路2：因为是有序的，所以从左上角开始比较
 *
 * @Author heshang.ink
 * @Date 2019/9/23 17:46
 */
public class 二维数组中的查找Solution {
	public boolean Find(int target, int[][] array) {
		if (array.length == 0 || array[0].length == 0) {
			return false;
		}
		int i = 0, j = array[0].length - 1;
		while (i < array.length && j >= 0) {
			if (array[i][j] == target) {
				return true;
			}
			if (target < array[i][j]) {
				j--;
			} else {
				i++;
			}
		}
		return false;
	}
}
