package com.hs.JianZhiOffer02.链表;


import com.hs.JianZhiOffer02.ListNode;

import java.util.ArrayList;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/12 20:34
 * version: 1.0
 */
public class 从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] ans = new int[list.size()];
        int i = 0;
        for (int size = list.size() - 1; size >= 0; size--) {
            ans[i++] = list.get(size);
        }
        return ans;
    }
}
