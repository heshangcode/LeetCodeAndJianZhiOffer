package com.hs.LeetCode02;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/1/20 22:56
 * version: 1.0
 */
public class LT88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = nums1.length - 1;
        int i = m - 1;
        int j = n - 1;
        while (j >= 0 && nums2[j] >= nums1[i]) {
            nums1[l] = nums2[j];
            l--;
            j--;
        }
        while (i >= 0 && nums2[j] < nums1[i]) {
            nums1[l] = nums1[i];
            i--;
            l--;
        }

    }

}
