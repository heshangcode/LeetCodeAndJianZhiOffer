package com.hs.JianZhiOffer.链表;

/**
 * 给定一个链表，若其中包含环，则输出环的入口节点。
 *
 * 若其中不包含环，则输出null。
 *
 * 样例
 * QQ截图20181202023846.png
 *
 * 给定如上所示的链表：
 * [1, 2, 3, 4, 5, 6]
 * 2
 * 注意，这里的2表示编号是2的节点，节点编号从0开始。所以编号是2的节点就是val等于3的节点。
 *
 * 则输出环的入口节点3.
 *
 * @Author heshang.ink
 * @Date 2019/9/30 20:38
 */
public class 链表中环的入口结点 {
	public ListNode EntryNodeOfLoop(ListNode head){
		if (head == null) {
			return null;
		}
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

	public ListNode getMeetingNode(ListNode head) {
		ListNode fast, slow;
		fast = slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return slow;
			}
		}
		return null;
	}
}
