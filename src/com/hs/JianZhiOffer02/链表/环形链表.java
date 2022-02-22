package com.hs.JianZhiOffer02.链表;

import com.hs.JianZhiOffer02.ListNode;

/**
 * 双指针，快慢指针，走一步，走 2 步
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/22 09:19
 * version: 1.0
 */
public class 环形链表 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
