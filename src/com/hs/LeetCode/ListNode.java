package com.hs.LeetCode;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * @Author heshang.ink
 * @Date 2019/3/16 14:58
 */

public class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
	}

	public static void main(String[] args) {

	}
}

class Solution {
	public ListNode reverseList(ListNode head) {
		System.out.println(head.val);
		return head;
	}
}
