package com.hs.排序;

import java.util.Arrays;

/**
 * 随机选一个数.
 *
 * @Author heshang.ink
 * @Date 2019/8/21 18:42
 */
public class 快速排序 {
	public static void main(String[] args) {
		int[] arr = new int[]{3, 8, 1, 2, 8, 7, 5, 6};
		System.out.println("快速排序前：" + Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
		System.out.println("快速排序后：" + Arrays.toString(arr));
	}
	public static void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			//轴点
			int p = arr[start];
			//两个指针进行移动
			int low = start;
			int high = end;
			while (low < high) {
				//处理左边比他大的数，一直比他小，high--
				while (low < high && arr[high] >= p) {
					high--;
				}
				arr[low] = arr[high];
				//处理右边比他小的数，一直比他小，low++
				while (low < high && arr[low] < p) {
					low++;
				}
				arr[high] = arr[low];
			}
			arr[low] = p;
			quickSort(arr, start, low);
			quickSort(arr, low + 1, end);

		}
	}
}
