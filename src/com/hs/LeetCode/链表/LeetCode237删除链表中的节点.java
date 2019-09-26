package com.hs.LeetCode.链表;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/9/25 17:25
 */
public class LeetCode237删除链表中的节点 {
	public void deleteNode(ListNode node) {
		if (node == null) {
			return;
		}
		int val = node.next.val;
		node.val = val;
		node.next = node.next.next;
	}
}
