package com.hs.JianZhiOffer02.DP;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/12 21:49
 * version: 1.0
 */
public class 青蛙跳台阶问题 {
    public int numWays(int n) {
        int a = 1, b = 1, ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (a + b) % 1000000007;
            a = b;
            b = ans;
        }
        return a;
    }
}
