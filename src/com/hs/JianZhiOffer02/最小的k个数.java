package com.hs.JianZhiOffer02;

import java.util.Arrays;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/13 18:12
 * version: 1.0
 */
public class 最小的k个数 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    public int[] getLeastNumbers1(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] arr, int low, int high, int k) {
        int j = quickSort(arr, low, high);
        if (j == k) {
            return Arrays.copyOfRange(arr, 0,j + 1);
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
        return -1;
    }
}
