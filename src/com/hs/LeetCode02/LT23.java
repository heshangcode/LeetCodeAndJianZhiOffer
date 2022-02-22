package com.hs.LeetCode02;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/1/23 17:49
 * version: 1.0
 */
public class LT23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode newList = new ListNode(Integer.MIN_VALUE);
        ListNode newHead = newList;
        for (int i = 0; i < lists.length; i++) {
            ListNode list1 = lists[i];
            ListNode mergeList = mergeList(newList, list1);
            while (mergeList != null) {
                mergeList = mergeList.next;
            }

        }
        return newList.next;
    }

    public ListNode mergeList(ListNode list1, ListNode list2) {
        ListNode newList = new ListNode(0);
        ListNode newHead = newList;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                newHead.next = list1;
                list1 = list1.next;
            } else {
                newHead.next = list2;
                list2 = list2.next;
            }
            newHead = newHead.next;
        }

        while (list1 != null) {
            newHead.next = list1;
            list1 = list1.next;
            newHead = newHead.next;
        }

        while (list2 != null) {
            newHead.next = list2;
            list2 = list2.next;
            newHead = newHead.next;
        }
        return newList.next;
    }
}
