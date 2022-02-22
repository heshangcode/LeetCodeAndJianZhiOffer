package com.hs.JianZhiOffer02;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/12 18:13
 * version: 1.0
 */
public class 替换空格 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%$20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
