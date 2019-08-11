package com.hs.LeetCode;

import com.hs.LeetCode.链表.ListNode;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/6/9 9:33
 */
public class 对链表进行插入排序147 {
	public ListNode insertionSortList(ListNode head) {
		/**
		 * 思路：首先一个新的extHead链表，把head遍历比较，把head里的值放入新的链表后面，生成新的链表
		 * extHead链表里就是排好序的
		 */
		if (head == null || head.next == null) {
			return head;
		}
		ListNode extHead = new ListNode(0);
		ListNode cur = head;
		ListNode p = extHead;
		//遍历head链表
		while (cur != null) {
			//这里把链表里的值和head里的值进行比较
			while (p.next != null && p.next.val < cur.val) {
				p = p.next;
			}
			ListNode next = cur.next;
			ListNode extNext = p.next;
			p.next = cur;
			cur.next = extNext;
			cur = next;
			//又把p指针放入到新的链表头，后面进行比较
			p = extHead;

		}
		return extHead.next;
	}
}
