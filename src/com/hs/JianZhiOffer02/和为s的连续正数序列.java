package com.hs.JianZhiOffer02;

import java.util.ArrayList;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/14 08:04
 * version: 1.0
 */
public class 和为s的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 1;
        int sum = 0;
        ArrayList<int[]> ans = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                sum += j;
                j++;
            } else if (sum > target) {
                sum -= i;
                i++;
            } else {
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++) {
                    arr[k - i] = k;
                }
                ans.add(arr);
                sum -= i;
                i++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
