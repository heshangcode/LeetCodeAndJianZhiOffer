package com.hs.LeetCode02;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/1/22 15:39
 * version: 1.0
 */
public class LT66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i > 0; i--) {
            digits[i]++;
            // 关键点在这里
            digits[i] = digits[i] % 10;
            // 不 == 0 说明，没有进位
            if (digits[i] != 0) {
                return digits;
            }
            // 如果进位了，继续操作，前一位就会++，如果前一位没有进位，就会 return 回去
        }

        // 到这里就说明出现了特殊情况，全部进位了
        // 补齐第一个数字
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;

    }
}
