package com.hs.JianZhiOffer02.DP;

/**
 * dp
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/16 08:39
 * version: 1.0
 */
public class 圆圈中最后剩下的数字 {
    public int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }


}
