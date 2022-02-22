package com.hs.JianZhiOffer02.二分;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/15 08:22
 * version: 1.0
 */
public class n1中缺失的数字 {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) >> 1;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }
}
