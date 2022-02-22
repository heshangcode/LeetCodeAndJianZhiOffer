package com.hs.LeetCode02;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/1/24 08:19
 * version: 1.0
 */
public class LT26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 不重复的下标
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[ans]) {
                nums[ans] = nums[i];
                ans++;
            }
        }
        return ans;
    }
}
