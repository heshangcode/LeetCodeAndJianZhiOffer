package com.hs.LeetCode.链表;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/9/26 8:16
 */
public class 定位环入口 {
	public ListNode getEntryNodeOfLoop(ListNode head) {
		ListNode meetingNode = getMeetingNode(head);
		if (meetingNode == null) {
			return null;
		}
		ListNode p1 = meetingNode;
		ListNode p2 = head;
		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}

	private ListNode getMeetingNode(ListNode head) {
		ListNode fast, slow;
		slow = fast = head;
		while (slow != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return slow;
			}
		}
		return null;
	}
}
