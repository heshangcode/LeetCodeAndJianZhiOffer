package com.hs.JianZhiOffer.链表;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 *
 * 当不存在公共节点时，返回空节点。
 *
 * 样例
 * 给出两个链表如下所示：
 * A：        a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 *
 * 输出第一个公共节点c1
 *
 * 暴力
 *
 * @Author heshang.ink
 * @Date 2019/10/11 21:30
 */
public class 两个链表的第一个公共结点Solution1 {
	public ListNode findFirstCommonNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode p1 = headA;
		ListNode p2 = headB;
		while (p1 != null) {
			while (p2 != null) {
				if (p1 == p2) {
					return p1;
				} else {
					p2 = p2.next;
				}
			}
			p2 = headB;
			p1 = p1.next;
		}
		return null;
	}
}
