package com.hs.LeetCode;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 *
 * @Author heshang.ink
 * @Date 2019/6/9 10:33
 */
public class 环形链表II142 {
	public ListNode detectCycle(ListNode head) {
		/**
		 * 思路：
		 * 1.首先找到环的相交点，
		 * 2.p1指向链表开头，p2指向相交点，然后p1，p2同时.next，相交边是换入口
		 * 证明：
		 * 找环的相交点：p1走一步，p2走两步，
		 * 入口a，环入口b，相遇c，a-b，x距离，b-c，y距离，p2走到相遇c，走的是2x+y+y，
		 * c再到b，就只需要x，跟链表头再到b，也相距x，
		 */
		if (head == null || head.next == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		//判断两个指针是否相同，找到相遇点
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				break;
			}
		}
		if (fast == null) {
			return null;
		}
		slow = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}

}
