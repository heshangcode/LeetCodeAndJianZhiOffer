package com.hs.JianZhiOffer02.链表;

import com.hs.JianZhiOffer02.ListNode;

/**
 * 双指针：newHead、curr
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/13 08:25
 * version: 1.0
 */
public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = newHead;
            newHead = curr;
            curr = next;
        }
        return newHead;
    }
}
