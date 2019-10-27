package com.hs.LeetCode.链表;

import java.util.Stack;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 *
 * 思路1：用栈每次放2个节点进去，然后pop出来，超出内存
 * 思路2：递推
 * 添加虚拟头结点 dummy。
 * 定义 cur 指针初始指向 dummy。
 * 定义 first 为 cur->next，second 为 first->next；若 first 或 second 为空，则终止循环。
 * 按照一定的次序，修改 cur、first 和 second结点的 next 指针，具体参见代码。
 * 将 cur 指向修改后的 first，接着从第3步循环。
 * @Author heshang.ink
 * @Date 2019/10/27 9:26
 */
public class LeetCode24两两交换链表中的节点Solution1 {
	public ListNode swapPairs(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		//指向反转成功的头
		ListNode cur = dummy;
		//指向未反转的头
		ListNode next = dummy.next;
		Stack<ListNode> stack = new Stack<>();
		while (next != null) {
			for (int i = 0; i < 2 && next != null; i++) {
				stack.add(next);
				next = next.next;
			}
			//弹出来
			while (!stack.isEmpty()) {
				cur.next = stack.pop();
				cur = cur.next;
			}
		}
		return dummy.next;

	}
}
