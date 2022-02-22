package com.hs.JianZhiOffer02.二分;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/12 22:04
 * version: 1.0
 */
public class 旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) {
                i = m + 1;
            } else if (numbers[m] < numbers[j]) {
                j = m;
            } else {
                j--;
            }
        }
        return numbers[i];
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int m = (right - left) / 2 + left;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] > target) {
                right = m - 1;
            } else {
                left = m + 1;
            }
        }
        return -1;
    }


}
