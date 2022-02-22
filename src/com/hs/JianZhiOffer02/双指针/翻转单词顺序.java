package com.hs.JianZhiOffer02.双指针;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/14 08:12
 * version: 1.0
 */
public class 翻转单词顺序 {
    public String reverseWords(String s) {
        String[] s1 = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (s1.equals(" ")) {
                sb.append(" ");
                continue;
            } else {
                sb.append(s1[i]);
            }
        }
        return s1.toString();
    }
}
