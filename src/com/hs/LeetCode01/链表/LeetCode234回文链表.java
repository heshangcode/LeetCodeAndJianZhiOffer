package com.hs.LeetCode01.链表;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/9/26 9:05
 */
public class LeetCode234回文链表 {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		//快慢指针找到链表的中点
		ListNode fast = head.next.next;
		ListNode slow = head.next;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		//翻转链表前半部分
		ListNode pre = null;
		ListNode next = null;
		while (head != slow) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		//如果是奇数个节点，去掉后半部分的第一个节点。

		if (fast != null) {
			slow = slow.next;
		}
		//回文校验
		while (pre != null) {
			if (pre.val != slow.val) {
				return false;
			}
			pre = pre.next;
			slow = slow.next;
		}

		return true;

	}


}
