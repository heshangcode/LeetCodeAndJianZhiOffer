package com.hs.LeetCode02;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/1/28 22:35
 * version: 1.0
 */
public class LT167 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length;
        while (l < r) {
            int numSum = numbers[l] + numbers[r];
            if (numSum == target) {
                return new int[]{l, r};
            }
            if (numSum < target) {
                l++;
            } else {
                r--;
            }
        }
        return null;
    }
}
