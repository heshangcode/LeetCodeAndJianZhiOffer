package com.hs.LeetCode.链表;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/9/26 8:19
 */
public class 计算环长度 {
	public int getLoopLength(ListNode head) {
		ListNode slow, fast;
		slow = fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		slow = slow.next;
		fast = fast.next.next;
		int len = 1;
		while (fast != slow) {
			slow = slow.next;
			fast = fast.next.next;
			len++;
		}
		return len;
	}
}
