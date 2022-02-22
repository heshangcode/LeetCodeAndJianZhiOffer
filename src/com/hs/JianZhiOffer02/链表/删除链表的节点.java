package com.hs.JianZhiOffer02.链表;

import com.hs.JianZhiOffer02.ListNode;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/13 08:01
 * version: 1.0
 */
public class 删除链表的节点 {
    //public ListNode deleteNode(ListNode head, int val) {
    //    ListNode p = new ListNode(0);
    //    p.next = head;
    //    ListNode curr = p;
    //    while (curr != null) {
    //        ListNode next = curr.next;
    //        if (next != null && next.val == val) {
    //            curr.next = next.next;
    //        } else {
    //            curr = next;
    //        }
    //    }
    //    return p.next;
    //}

    public ListNode deleteNode(ListNode head, int val) {
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode curr = p;
        while (curr != null) {
            ListNode next = curr.next;
            if (next != null && next.val == val) {
                curr.next = next.next;
            } else {
                curr = next;
            }
        }
        return p.next;
    }
}
