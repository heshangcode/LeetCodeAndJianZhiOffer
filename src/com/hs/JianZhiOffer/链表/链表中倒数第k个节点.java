package com.hs.JianZhiOffer.链表;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * <p>
 * 注意：
 * <p>
 * k >= 0;
 * 如果k大于链表长度，则返回 NULL;
 * 样例
 * 输入：链表：1->2->3->4->5 ，k=2
 * <p>
 * 输出：4
 * <p>
 * 思路：快慢指针
 *
 * @Author heshang.ink
 * @Date 2019/9/30 19:55
 */
public class 链表中倒数第k个节点 {
	public ListNode FindKthToTail(ListNode head, int k) {
		if (head == null || k == 0) {
			return null;
		}
		ListNode p1,p2;
		p1 = p2 = head;
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
