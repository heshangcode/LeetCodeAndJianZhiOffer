package com.hs.JianZhiOffer02;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/14 07:57
 * version: 1.0
 */
public class 和为s的两个数字 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int num = nums[left] + nums[right];
            if (num == target) {
                return new int[]{nums[left], nums[right]};
            }
            if (num > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{};
    }
}
