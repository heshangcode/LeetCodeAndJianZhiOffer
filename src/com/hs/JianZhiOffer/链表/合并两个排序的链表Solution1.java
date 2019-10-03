package com.hs.JianZhiOffer.链表;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。
 *
 * 样例
 * 输入：1->3->5 , 2->4->5
 *
 * 输出：1->2->3->4->5->5
 *
 * 思路1：开辟一个新的链表存放
 * @Author heshang.ink
 * @Date 2019/9/30 21:06
 */
public class 合并两个排序的链表Solution1 {
	public ListNode Merge(ListNode list1,ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		ListNode head = new ListNode(-1);
		ListNode p = head;
		ListNode p1 = list1;
		ListNode p2 = list2;
		while (p1 != null && p2 != null) {
			if (p1.val < p2.val) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}
			p = p.next;
		}
		p.next = p1 != null ? p1 : p2;
		/*if (p1 != null) {
			p.next = p1;
		}
		if (p2 != null) {
			p.next = p2;
		}*/

		return head.next;
	}
}
