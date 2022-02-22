package com.hs.JianZhiOffer02;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 先排序，再统计大小王的数量，最大值--最小值 < 5，就可以拿大小王补充
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/16 09:14
 * version: 1.0
 */
public class 扑克牌中的顺子 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int joker = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                joker++;
            } else if (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                return false;
            }

        }
        return nums[nums.length - 1] - nums[joker] < 5;
    }
}
