package com.hs.LeetCode.链表;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/9/26 8:10
 */
public class 输出单链表倒数第K个节点 {
	public ListNode findKthTail(ListNode head, int k) {
		if (head == null || k == 0) {
			return null;
		}
		ListNode p1 = head, p2 = head;
		//p1先出发，前进K个节点
		for (int i = 0; i < k; i++) {
			if (p1 != null) {   //防止k大于链表节点的个数
				p1 = p1.next;
			} else {
				return null;
			}
		}
		while (p1 != null) {    //如果p1没有到达链表结尾，则p1，p2继续遍历
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;  //当p1到达末尾时，p2正好指向倒数第K个节点
	}
}
