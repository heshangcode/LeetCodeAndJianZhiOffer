package com.hs.LeetCode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * @Author heshang.ink
 * @Date 2019/6/6 18:49
 */
public class 删除链表的倒数第N个节点19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p1, p2;
		p1 = p2 = dummy;
		for (int i = 0; i < n; i++) {
			p2 = p2.next;
		}
		while (p2 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		//要删除的节点
		p1.next = p1.next.next;
		return dummy.next;
	}
}
