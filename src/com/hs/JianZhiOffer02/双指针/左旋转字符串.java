package com.hs.JianZhiOffer02.双指针;

/**
 * 分开 2 个字符串相加就行
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/14 08:39
 * version: 1.0
 */
public class 左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        return sb.append(s.substring(n, s.length())).append(s, 0, n).toString();
    }
}
