package com.hs.JianZhiOffer.链表;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留。
 * <p>
 * 样例1
 * 输入：1->2->3->3->4->4->5
 * <p>
 * 输出：1->2->5
 * 样例2
 * 输入：1->1->1->2->3
 * <p>
 * 输出：2->3
 * 思路：双指针吧
 *
 * @Author heshang.ink
 * @Date 2019/9/25 17:26
 */
public class 删除链表中重复的节点 {
	public ListNode deleteDuplication(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = dummy, q = p.next;
		while (p.next != null) {
			//往后寻找相邻元素是否相同
			while (q != null && p.next.val == q.val) {
				q = q.next;
			}
			//这里判断是否是一个元素
			if (p.next.next == q) {
				p = p.next;
			} else {
				//删除中间重复元素
				p.next = q;
			}

		}
		return dummy.next;

	}
}
