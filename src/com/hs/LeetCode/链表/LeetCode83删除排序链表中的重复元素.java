package com.hs.LeetCode.链表;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路1：首先是有序的，就可以前后判断
 * 思路2：如果无序，用hashset遍历存储，然后判断是否包含
 *
 * @Author heshang.ink
 * @Date 2019/8/10 17:32
 */
public class LeetCode83删除排序链表中的重复元素 {
	public ListNode deleteDuplicates(ListNode head) {

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
