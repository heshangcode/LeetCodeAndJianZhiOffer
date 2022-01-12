package com.hs.LeetCode01.链表;

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
public class LeetCode25K个一组翻转链表Solution3 {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		while (prev != null) {
			prev = reverse(prev, k);
		}
		return dummy.next;
	}


	public ListNode reverse(ListNode prev, int k) {
		ListNode last = prev;
		for (int i = 0; i < k + 1; i++) {
			last = last.next;
			//这里为了找到不足k个节点的一组
			if (i != k && last == null) {
				return null;
			}
		}
		// 这个反转有点巧妙，比如k = 3，1->2->3->4->5，此时last = 4，prev=dummy，
		// tail = 1,curr=2,就是把2放到1前面，变为了2->1->3，然后再把3放到2前面
		//变为之后的尾巴
		ListNode tail = prev.next;
		// 始终指向要变的值
		ListNode curr = prev.next.next;
		//反转链表
		while (curr != last) {
			ListNode next = curr.next;
			curr.next = prev.next;
			prev.next = curr;
			tail.next = next;
			curr = next;
		}
		return tail;

	}
}
