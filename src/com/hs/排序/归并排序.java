package com.hs.排序;

import java.util.Arrays;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/8/21 18:04
 */
public class 归并排序 {
	public static void main(String[] args) {
		int[] arr = new int[]{2, 8, 13, 11, 6, 7};
		System.out.println("归并排序前：" + Arrays.toString(arr));
		mergeSort(arr, 0, arr.length - 1);
		System.out.println("归并排序后：" + Arrays.toString(arr));
	}

	/**
	 * 先拆分
	 *
	 * @param arr
	 * @param low
	 * @param high
	 */
	public static void mergeSort(int[] arr, int low, int high) {
		int mid = low + (high - low) / 2;
		if (low < high) {
			//继续拆分左边
			mergeSort(arr, low, mid);
			//继续拆分右边
			mergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
			System.out.println(Arrays.toString(arr));
		}
	}

	/**
	 * //将有序的A[i,...,m]和A[m+1，...,n]归并为有序的B[i,...,n]
	 *
	 * @param arr
	 * @param left
	 * @param mid
	 * @param right
	 */
	private static void merge(int[] arr, int left, int mid, int right) {


		if (left <= right) {
			int[] newArray = new int[right - left + 1];
			int i = left;
			int j = mid + 1;
			int index = 0;
			while (i <= mid && j <= right) {
				if (arr[i] <= arr[j]) {
					newArray[index++] = arr[i++];
				} else {
					newArray[index++] = arr[j++];
				}
			}
			while (i <= mid) {
				newArray[index++] = arr[i++];
			}
			while (j <= right) {
				newArray[index++] = arr[j++];
			}
			for (int k = 0; k < newArray.length; k++) {
				arr[k + left] = newArray[k];
			}
		}
	}
}
