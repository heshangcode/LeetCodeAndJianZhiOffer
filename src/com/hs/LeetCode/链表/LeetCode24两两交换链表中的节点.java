package com.hs.LeetCode.链表;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路1：虚拟头节点，p指向下一对交换的前面，node1为交换第一个，node2为第二个，
 * 两两交换，指针变化，然后p为下一对交换的前面，就为node1
 *
 * @Author heshang.ink
 * @Date 2019/8/11 17:05
 */
public class LeetCode24两两交换链表中的节点 {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = dummy, node1, node2;

		while (p.next != null && p.next.next != null) {
			node1 = p.next;
			node2 = node1.next;
			ListNode next = node2.next;

			p.next = node2;
			node2.next = node1;
			node1.next = next;

			p = node1;
		}
		return dummy.next;
	}
}
