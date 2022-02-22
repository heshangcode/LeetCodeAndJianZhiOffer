package com.hs.JianZhiOffer02.DP;

/**
 * DP，用数组记录
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/13 20:37
 * version: 1.0
 */
public class 连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
