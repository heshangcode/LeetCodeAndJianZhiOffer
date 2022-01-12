package com.hs.LeetCode01.链表;

import java.util.Stack;

/**
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * <p>
 *  
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 进阶:
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * 示例:
 * <p>
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路1：链表是正序的，要不然就是链表反转，学 LeetCode 2那种做
 * 思路2：把链表值遍历放入栈中，栈顶元素相加，判断是否进位
 * 插入新链表是头插法
 *
 * @Author heshang.ink
 * @Date 2019/8/11 9:58
 */
public class LeetCode445两数相加II {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode newHead = new ListNode(0);
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		int carry = 0;
		while (l1 != null) {
			stack1.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			stack2.push(l2.val);
			l2 = l2.next;
		}
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			int x = stack1.isEmpty() ? 0 : stack1.peek();
			int y = stack2.isEmpty() ? 0 : stack2.peek();
			int sum = x + y + carry;
			carry = sum / 10;
			ListNode node = new ListNode(sum % 10);
			node.next = newHead.next;
			newHead.next = node;
			if(!stack1.isEmpty()) {
				stack1.pop();
			}
			if(!stack2.isEmpty()) {
				stack2.pop();
			}
		}
		if (carry > 0) {
			ListNode node = new ListNode(carry);
			node.next = newHead.next;
			newHead.next = node;
		}
		return newHead.next;

	}
}
