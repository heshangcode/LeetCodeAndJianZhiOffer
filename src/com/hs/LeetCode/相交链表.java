package com.hs.LeetCode;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/4/11 19:39
 */
public class 相交链表 {
	public static void main(String[] args) {

	}

	public ListNode sortList(ListNode head) {
		ListNode pA = head;
		ListNode pB ;
		ListNode newNode = new ListNode(0);
		ListNode p = newNode;
		//遍历整个链表
		while (pA != null) {
			int sVal = pA.val;
			pB = pA;
			while (pB.next != null) {
				if (pB.next.val < sVal) {
					sVal = pB.next.val;
				}
				pB = pB.next;
			}
			ListNode node = new ListNode(sVal);
			p.next = node;
			p = node;
			pA = pA.next;
		}
		return newNode.next;
	}
}
