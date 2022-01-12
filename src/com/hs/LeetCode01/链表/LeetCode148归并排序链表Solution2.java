package com.hs.LeetCode01.链表;

/**
 * 思路2：递推
 * https://leetcode-cn.com/problems/sort-list/solution/148-pai-xu-lian-biao-bottom-to-up-o1-kong-jian-by-/
 *
 * @Author heshang.ink
 * @Date 2019/9/24 8:16
 */
public class LeetCode148归并排序链表Solution2 {
	public ListNode sortList(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = head;
		int length = 0;
		while (p != null) {
			length++;
			p = p.next;
		}

		for (int size = 1; size < length; size = size * 2) {
			ListNode cur = dummy.next;
			ListNode tail = dummy;
			while (cur != null) {
				ListNode left = cur;    //前size个元素
				ListNode right = cut(left, size);   //分割
				cur = cut(right, size); //继续分割

				tail.next = merge(left, right);
				while (tail.next != null) {
					tail = tail.next;
				}
			}
		}
		return dummy.next;
	}

	private ListNode cut(ListNode head, int n) {
		ListNode p = head;
		while (--n > 0 && p != null) {
			p = p.next;
		}
		if (p == null) {
			return null;
		}
		ListNode next = p.next;
		p.next = null;
		return next;
	}

	private ListNode merge(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while (left != null && right != null) {
			if (left.val < right.val) {
				p.next = left;
				p = left;
				left = left.next;
			} else {
				p.next = right;
				p = right;
				right = right.next;
			}
		}
		p.next = left != null ? left : right;
		return dummy.next;
	}
}
