package com.hs.LeetCode01.链表;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/9/26 8:14
 */
public class 判断链表是否有环 {
	public boolean isExistLoop(ListNode head) {
		ListNode fast, slow;
		slow = fast = head;
		while (slow != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}
}
