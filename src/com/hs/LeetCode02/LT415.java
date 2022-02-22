package com.hs.LeetCode02;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/11 08:58
 * version: 1.0
 */
public class LT415 {
    public String addStrings(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int i = chars1.length - 1, j = chars2.length - 1;
        int[] ans = new int[Math.max(i, j) + 1];
        int a = ans.length - 1;
        int tmp = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? chars1[i] : 0;
            int n2 = j >= 0 ? chars2[j] : 0;
            int num = n1 + n2 + tmp;
            tmp = num / 10;
            System.out.println(a);
            ans[a--] = num % 10;
        }
        if (tmp != 0) {
            ans[0] = 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int an : ans) {
            sb.append(an);
        }
        return sb.toString();

    }
}
