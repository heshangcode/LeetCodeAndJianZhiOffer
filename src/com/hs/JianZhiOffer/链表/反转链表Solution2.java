package com.hs.JianZhiOffer.链表;

/**
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 *
 * 样例
 * 输入:1->2->3->4->5->NULL
 *
 * 输出:5->4->3->2->1->NULL
 * 思路1：直接在链表上反转，空间复杂度O(1)，时间复杂度O(n)
 * @Author heshang.ink
 * @Date 2019/9/30 20:57
 */
public class 反转链表Solution2 {
	public ListNode ReverseList(ListNode head) {
		// 一直指向反转后链表的头
		ListNode newHead = null;
		// 一直指向未反转的链表的头
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = newHead;
			newHead = cur;
			cur = next;
		}
		return newHead;
	}
}
