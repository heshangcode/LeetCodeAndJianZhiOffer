package com.hs.JianZhiOffer02.位运算;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/13 07:51
 * version: 1.0
 */
public class 二进制中1的个数 {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}
