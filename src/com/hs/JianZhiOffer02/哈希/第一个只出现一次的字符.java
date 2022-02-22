package com.hs.JianZhiOffer02.哈希;

import java.util.HashMap;
import java.util.HashSet;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/13 20:41
 * version: 1.0
 */
public class 第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.containsKey(c));
        }
        for (char c : s.toCharArray()) {
            if (!map.get(c)) {
                return c;
            }
        }
        return ' ';
    }
}
