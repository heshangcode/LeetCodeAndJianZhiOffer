package com.hs.LeetCode;

/**
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * @Author heshang.ink
 * @Date 2019/6/6 7:44
 */
public class 环形链表141 {

	public boolean hasCycle(ListNode head) {
		/**
		 * 思路1：
		 * 用一个hashset，遍历链表，如果在hashset有，则是环，没有则加入hashset
		 * 思路2：
		 * 快慢指针法，类比操场跑步，两个人速度不一样，但是成环，肯定会相遇，
		 * 一个slow每次走一个节点，fast指针走2个节点，如果两个相等则换，反之
		 */
		/*ListNode p = head;
		HashSet<ListNode> hashSet = new HashSet<>();
		while (p != null) {
			//判断hashset是否含值
			if (hashSet.contains(p)) {
				return true;
			} else {
				hashSet.add(p);
			}
			p = p.next;
		}
		return false;*/
		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow,fast;
		slow = head;
		fast = head.next;
		//判断两个指针是否相同
		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}



		return true;
	}

}
