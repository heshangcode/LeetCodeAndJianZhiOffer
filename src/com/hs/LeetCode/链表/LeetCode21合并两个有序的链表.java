package com.hs.LeetCode.链表;

import com.hs.LeetCode.ListNode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路：依次比较两个链表,需要一个哨兵节点
 * 在原链表上操作，也可以新建一个链表（空间为O(l1 + l2)）
 * @Author heshang.ink
 * @Date 2019/8/11 11:30
 */
public class LeetCode21合并两个有序的链表 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		//在返回节点之前保持对节点的不变引用。
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				prev.next = l1;
				l1 = l1.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;

		}
		//此时l1和l2中只有一个非空，所以连接
		//非空列表到合并列表的末尾。
		prev.next = l1 == null ? l2 : l1;
		return dummy.next;
	}
}
