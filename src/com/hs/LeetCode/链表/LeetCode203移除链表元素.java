package com.hs.LeetCode.链表;

import com.hs.LeetCode.ListNode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * 思路1：如果删的是第一个，最好有个虚拟头节点，这样才能一步到位
 * @Author heshang.ink
 * @Date 2019/8/11 10:31
 */
public class LeetCode203移除链表元素 {
	public com.hs.LeetCode.ListNode removeElements1(ListNode head, int val) {
		if (head == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		com.hs.LeetCode.ListNode cur = dummy;
		while (cur != null && cur.next != null) {
			if (cur.next.val == val) {
				com.hs.LeetCode.ListNode node = cur.next.next;
				cur.next = node;
			} else {
				cur = cur.next;
			}

		}
		return dummy.next;
	}
	public com.hs.LeetCode.ListNode removeElements2(com.hs.LeetCode.ListNode head, int val) {
		if (head == null) {
			return head;
		}
		com.hs.LeetCode.ListNode cur = head;
		while (cur != null && cur.val == val) {
			cur = cur.next;
		}
		while (cur != null && cur.next != null) {
			if (cur.next.val == val) {
				ListNode node = cur.next.next;
				cur.next = node;
				cur = cur.next;
			} else {
				cur = cur.next;
			}
		}
		return head;
	}
}
