package com.hs.LeetCode;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * @Author heshang.ink
 * @Date 2019/6/6 20:36
 */
public class 删除排序链表中的重复元素83 {
	public ListNode deleteDuplicates(ListNode head) {
		/**
		 * 思路1：首先是有序的，就可以前后判断
		 * 2：如果无序，用hashset遍历存储，然后判断是否包含
		 */

		ListNode p = head;
		while (p != null && p.next != null) {
			if (p.next.val == p.val) {
				p.next = p.next.next;
			} else {
				p = p.next;
			}

		}
		return head;
	}

}
