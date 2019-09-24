package com.hs.LeetCode.链表;

/**
 * 思路1：递归，归并排序实现
 * 时间复杂度：O(nlongn)
 * 空间复杂度：O(logn)
 * @Author heshang.ink
 * @Date 2019/9/24 8:16
 */
public class LeetCode148归并排序链表Solution1 {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		//双指针法
		ListNode fast = head.next, slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode tmp = slow.next;
		slow.next = null;
		//拆分
		ListNode left = sortList(head);
		ListNode right = sortList(tmp);

		//归并
		ListNode h = new ListNode(0);
		ListNode res = h;
		while (left != null && right != null) {
			if (left.val < right.val) {
				h.next = left;
				left = left.next;
			} else {
				h.next = right;
				right = right.next;
			}
			h = h.next;
		}
		h.next = left != null ? left : right;
		return res.next;
	}
}
