package com.hs.LeetCode01.链表;

import java.util.Stack;

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
 *
 * @Author heshang.ink
 * @Date 2019/10/26 21:20
 */
public class LeetCode25K个一组翻转链表Solution1 {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) {
			return head;
		}
		//利用一个栈去存放节点
		Stack<ListNode> stack = new Stack<>();
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		//指向反转成功的头
		ListNode curr = dummy;
		//指向未反转的头
		ListNode next = dummy.next;
		while (next != null) {
			//给栈放入k个节点
			for (int i = 0; i < k && next != null; i++) {
				stack.add(next);
				next = next.next;
			}
			//判断栈是不是k个节点，如果不是，就不需要反转
			if (stack.size() != k) {
				return dummy.next;
			}
			//把栈里的节点pop出去，放入之前那个节点上就反转了
			while (!stack.isEmpty()) {
				curr.next = stack.pop();
				curr = curr.next;
			}
		}
		return dummy.next;
	}
}
