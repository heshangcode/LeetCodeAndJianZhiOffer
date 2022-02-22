package com.hs.JianZhiOffer02;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/13 07:58
 * version: 1.0
 */
public class 打印从1到最大的n位数 {
    public int[] printNumbers(int n) {
        int end = (int) (Math.pow(10, n) - 1);
        int[] res = new int[end];
        for (int i = 0; i < end; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    //public int[] printNumbers(int n) {
    //    StringBuilder sb = new StringBuilder();
    //    for (int i = 0; i < n; i++) {
    //        sb.append("9");
    //    }
    //    Integer a = Integer.valueOf(sb.toString());
    //    int[] ans = new int[a];
    //    for (Integer i = 0; i < a; i++) {
    //        ans[i] = i + 1;
    //    }
    //    return ans;
    //}
}
