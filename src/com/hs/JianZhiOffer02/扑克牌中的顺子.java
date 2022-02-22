package com.hs.JianZhiOffer02;

import java.util.Arrays;
import java.util.HashSet;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/16 09:14
 * version: 1.0
 */
public class 扑克牌中的顺子 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                return false;
            }
            min = Math.min(nums[i], min);
        }
        return nums[nums.length - 1] - min < 5;
    }
}
