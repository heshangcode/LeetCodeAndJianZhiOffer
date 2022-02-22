package com.hs.JianZhiOffer02.二分;

import java.util.Arrays;

/**
 * 利用快排思想，提前中止
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/13 18:12
 * version: 1.0
 */
public class 最小的k个数 {


    public int[] getLeastNumbers1(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] arr, int low, int high, int k) {
        int j = quickSort(arr, low, high);
        System.out.println(j);

        if (j == k) {
            return Arrays.copyOf(arr, j + 1);
        }
        return j > k ? quickSearch(arr, low, j - 1, k) : quickSearch(arr, j + 1, high, k);
    }

    public int quickSort(int[] array, int start, int end) {
        if (start < end) {
            int p = array[start];
            int l = start, r = end;
            while (l < r) {
                while (l < r && array[r] > p) {
                    r--;
                }
                array[l] = array[r];
                while (l < r && array[l] <= p) {
                    l++;
                }
                array[r] = array[l];
            }
            array[l] = p;
            return l;
        }
        return start;
    }


    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        return quickSearch2(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch2(int[] arr, int low, int high, int k) {
        int p = quickSort2(arr, low, high);
        if (p == k) {
            return Arrays.copyOf(arr, p + 1);
        }
        return p > k ? quickSearch2(arr, low, p - 1, k) : quickSearch2(arr, p + 1, high, k);
    }

    private int quickSort2(int[] arr, int start, int end) {
        while (start < end) {
            int p = arr[start];
            int l = start, r = end;
            while (l < r) {
                while (l < r && arr[r] > p) {
                    r--;
                }
                arr[l] = arr[r];

                while (l < r && arr[l] <= p) {
                    l++;
                }
                arr[r] = arr[l];
            }
            arr[l] = p;
            return l;
        }
        return start;
    }
}
