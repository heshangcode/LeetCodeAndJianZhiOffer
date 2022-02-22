package com.hs.LeetCode02;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/1/27 18:01
 * version: 1.0
 */
public class LT24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead;
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = p.next.next;
            ListNode next = p.next.next.next;

            p.next = node2;
            node2.next = node1;
            node1.next = next;

            p = node1;

        }
        return newHead.next;
    }
}
