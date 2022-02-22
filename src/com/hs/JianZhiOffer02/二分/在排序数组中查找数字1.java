package com.hs.JianZhiOffer02.二分;

/**
 * 二分，根据下标来判断
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/14 08:26
 * version: 1.0
 */
public class 在排序数组中查找数字1 {
    public int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    private int helper(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) >> 1;
            if (nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }
}
