package com.hs.JianZhiOffer02.链表;

import com.hs.JianZhiOffer02.ListNode;

/**
 * 双指针，快慢指针，走一步，走 2 步
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/22 09:19
 * version: 1.0
 */
public class 环形链表2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        boolean hasR = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasR = true;
                break;
            }
        }
        System.out.println(hasR);
        System.out.println(fast.val == slow.val);
        if (!hasR) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
