package com.hs.JianZhiOffer02;

/**
 * 位运算，&与，全为 1，^异或，不相同为 1
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/16 09:11
 * version: 1.0
 */
public class 不用加减乘除做加法 {
    public int add(int a, int b) {
        // 当进位为 0 时跳出
        while (b != 0) {
            // c = 进位
            int c = (a & b) << 1;
            // a = 非进位和
            a ^= b;
            // b = 进位
            b = c;
        }
        return a;
    }
}
