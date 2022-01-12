package com.hs.LeetCode01;


/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * @Author heshang.ink
 * @Date 2019/6/8 18:50
 */
public class 重排链表143 {
	public static void reorderList(ListNode head) {
		/**
		 * 思路：使用双指针将链表分成两段
		 * 将链表后半段进行翻转
		 * 将两段链表进行合并
		 */
		if (head == null || head.next == null) {
			return;
		}
		ListNode p1 = head;
		ListNode p2 = head;
		//找到链表的后半段，双指针法
		while (p2 != null && p2.next != null && p2.next.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
		}
		p2 = p1.next;
		p1.next = null;
		p1 = head;
		//后半段的链表进行翻转
		//ListNode head2 = p2;
		ListNode pre = null;
		while (p2 != null) {
			ListNode next2 = p2.next;
			p2.next = pre;
			pre = p2;
			p2 = next2;
		}
		p2 = pre;
		//两条链表合并,把p1作为主链表
		while(p2 != null){
			ListNode next1 = p1.next;
			ListNode next2 = p2.next;
			p1.next = p2;
			p2.next = next1;
			p1 = next1;
			p2 = next2;
		}

	}


}
