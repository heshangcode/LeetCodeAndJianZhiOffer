package com.hs.LeetCode.链表;

import com.hs.LeetCode.ListNode;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路1：迭代版，
 * 思路2：递归版
 *
 * @Author heshang.ink
 * @Date 2019/8/10 14:52
 */
public class LeetCode206反转链表 {
	public ListNode reverseList1(ListNode head) {
		if (head == null) {
			return null;
		}
		//指向反转成功的链表头
		ListNode newHead = null;
		//指向还没有反转的链表
		ListNode curHead = head;
		while (curHead != null) {
			ListNode next = curHead.next;
			curHead.next = newHead;
			newHead = curHead;
			curHead = next;
		}
		return newHead;
	}

	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = reverseList2(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
}

