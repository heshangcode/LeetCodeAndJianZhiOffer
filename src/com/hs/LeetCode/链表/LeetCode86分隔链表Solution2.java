package com.hs.LeetCode.链表;

import com.hs.LeetCode.ListNode;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 思路1：遍历链表，当前节点值 > x，给他放到最后一个节点的后面
 *
 * @Author heshang.ink
 * @Date 2019/8/10 17:34
 */
public class LeetCode86分隔链表Solution2 {
	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return null;
		}
		ListNode min = new ListNode(0);
		ListNode minCur = min;
		ListNode max = new ListNode(0);
		ListNode maxCur = max;
		while (head != null) {
			if (head.val < x) {
				minCur.next = new ListNode(head.val);
				minCur = minCur.next;
			} else {
				maxCur.next = new ListNode(head.val);
				maxCur = maxCur.next;
			}
			head = head.next;
		}
		minCur.next = max.next;
		return min.next;
	}
}
