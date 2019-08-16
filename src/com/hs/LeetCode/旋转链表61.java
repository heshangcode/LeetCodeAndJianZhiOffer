package com.hs.LeetCode;


/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * @Author heshang.ink
 * @Date 2019/6/8 16:50
 */
public class 旋转链表61 {
	public ListNode rotateRight(ListNode head, int k) {
		/**
		 * 思路：1，2，3，4，5，k=2，把k给链表大小取余，把4,5断开，然后链接上1,2,3，前提是必须找到3
		 */
		if (head == null) {
			return null;
		}
		if (k == 0) {
			return head;
		}
		int size = 0;
		ListNode p1 = head;
		ListNode pS = head;
		//遍历链表大小，取余，移动位置
		while (pS != null) {
			size++;
			pS = pS.next;
		}
		k = k % size;
		if (k == 0) {
			return head;
		}
		//找到要断开的节点前一个节点，小坑在-1
		for (int i = 0; i < size - k - 1; i++) {
			p1 = p1.next;
		}
		//pre断开的节点
		ListNode pre = p1.next;
		ListNode p = pre;
		p1.next = null;
		while (pre.next != null) {
			pre = pre.next;
		}
		pre.next = head;
		return p;
	}

}
