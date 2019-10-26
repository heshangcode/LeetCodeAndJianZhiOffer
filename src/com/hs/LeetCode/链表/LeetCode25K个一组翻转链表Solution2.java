package com.hs.LeetCode.链表;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 *
 * 思路1：利用栈，空间不符合要求是O(k)
 * 思路2：递归，
 * 1.依据k找到即将要翻转的k个节点的起点和终点（不满k个不翻转）
 * 2.利用双指针方法对起点和终点区间内的节点进行翻转
 * 3.递归调用处理后续节点
 * 思路3：非递归
 * @Author heshang.ink
 * @Date 2019/10/26 21:20
 */
public class LeetCode25K个一组翻转链表Solution2 {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) {
			return head;
		}
		//区间[start,end]的链表反转
		ListNode start, end;
		start = end = head;
		for (int i = 0; i < k; i++) {
			//这个就是节点数量不足k个就不需要反转
			// 这个放在前面是防止end.next 空指针异常
			if (end == null) {
				return head;
			}
			end = end.next;
		}
		//反转这个区间的节点，返回头节点
		ListNode newHead = reverse(start, end);
		start.next = reverseKGroup(end, k);
		return newHead;

	}

	/**
	 * 这里就是把[start,end)区间内的链表反转
	 * @param start
	 * @param end
	 * @return
	 */
	public ListNode reverse(ListNode start, ListNode end) {
		//指向反转好的链表头
		ListNode prev = null;
		//指向未反转的链表的头
		ListNode curr = start;
		while (curr != end) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
}
