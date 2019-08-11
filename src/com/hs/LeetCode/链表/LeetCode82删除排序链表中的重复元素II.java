package com.hs.LeetCode.链表;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路1：虚拟头节点，一步到位处理，判断相邻之间的数字是否一样
 * 只需要两个指针，一个指针 pre 代表重复数字的前边的一个指针，另一个指针 cur 用来遍历链表。
 * d 代表哨兵节点，用来简化边界条件，初始化为 head 指针的前一个节点。p 代表 pre，c 代表 cur。
 * https://leetcode.wang/leetCode-82-Remove-Duplicates-from-Sorted-ListII.html
 *
 * @Author heshang.ink
 * @Date 2019/8/11 10:51
 */
public class LeetCode82删除排序链表中的重复元素II {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = head, pre = dummy;
		while (cur != null && cur.next != null) {
			//记录这个值有没有重复，后面判断进行删除
			boolean equal = false;
			//cur 和 cur.next 相等，cur 不停后移
			while (cur != null && cur.next != null && cur.val == cur.next.val) {
				equal = true;
				cur = cur.next;
			}
			//发生了相等的情况
			// pre.next 直接指向 cur.next 删除所有重复数字
			if (equal) {
				pre.next = cur.next;
				//还原
				equal = false;
			} else {
				//没有发生相等的情况
				//pre 移到 cur 的地方
				pre = cur;
			}
			//cur 后移
			cur = cur.next;
		}
		return dummy.next;

	}
}
