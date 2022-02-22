package com.hs.LeetCode02;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/1/26 09:07
 * version: 1.0
 */
public class LT75 {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int i = 0;

        while (l <= r && i < nums.length - 1) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[l];
                nums[l] = tmp;
                l++;
                i++;
            }
            if (nums[i] == 1) {
                i++;
            }

            if (nums[i] == 2) {
                int tmp = nums[i];
                nums[i] = nums[r];
                nums[r] = tmp;
                r--;
            }
        }
    }
}
