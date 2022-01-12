package com.hs.LeetCode01;


/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/6/6 11:01
 */
public class 链表的中间结点876 {
	public ListNode middleNode(ListNode head) {
		/**
		 * 思路1：双指针法，p1每次走一个，p2每次走两个，p2到链表最后，当p2.next为空时，p1就是中间结点
		 * 思路2：遍历出来链表放到数组里，然后array[length/2]就是，
		 * 1和2时间都为O(n)，1空间O(1)，2空间O(n)
		 */
		ListNode p1, p2;
		p1 = p2 = head;
		if (head == null) {
			return null;
		}
		//特殊情况，1,2
		if (p1.next != null && p1.next.next == null) {
			return p1.next;
		}
		while (p1 != null && p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
		}
		return p1;
	}
}
