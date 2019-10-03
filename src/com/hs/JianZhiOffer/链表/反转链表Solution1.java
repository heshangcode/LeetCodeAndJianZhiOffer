package com.hs.JianZhiOffer.链表;

import java.util.Stack;

/**
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 *
 * 样例
 * 输入:1->2->3->4->5->NULL
 *
 * 输出:5->4->3->2->1->NULL
 * 思路1：用栈或者数组，空间复杂度O(n)，时间复杂度O(n)
 * @Author heshang.ink
 * @Date 2019/9/30 20:57
 */
public class 反转链表Solution1 {
	public ListNode ReverseList(ListNode head) {
		Stack<Integer> stack = new Stack<>();
		ListNode p = head;
		while (p != null) {
			stack.add(p.val);
			p = p.next;
		}
		ListNode newHead = new ListNode(0);
		ListNode p2 = newHead;
		while (!stack.isEmpty()) {
			p2.next = new ListNode(stack.pop());
			p2 = p2.next;
		}
		return newHead.next;
	}
}
