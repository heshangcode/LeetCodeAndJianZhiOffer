package com.hs.JianZhiOffer02;

import java.util.HashMap;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/13 18:07
 * version: 1.0
 */
public class 数组中出现次数超过一半的数字 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = nums.length >> 1;
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            if (map.get(num) > ans) {
                return num;
            }
        }
        return -1;
    }
}
