package com.hs.LeetCode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 *
 * @Author heshang.ink
 * @Date 2019/6/7 8:33
 */
public class 合并两个有序的链表21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		/**
		 * 思路：新建一个链表头，比较l1,l2的节点放入到新的链表头
		 */
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else {
			//遍历比较
			while (l1 != null && l2 != null) {
				if (l1.val < l2.val) {
					p.next = l1;
					l1 = l1.next;
				} else {
					p.next = l2;
					l2 = l2.next;
				}
				p = p.next;
			}
			//l1 或者 l2里还有
			if (l1 != null) {
				p.next = l1;
			}
			if (l2 != null) {
				p.next = l2;
			}
			return dummy.next;
		}

	}

}
