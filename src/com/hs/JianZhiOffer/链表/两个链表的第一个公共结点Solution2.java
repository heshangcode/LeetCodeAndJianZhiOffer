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
 * 思路：
 * 假设1：
 * 两个有交点：A：a1---c1 长度为a，B：b1---c1 长度为b，c1---c3 长度为c，
 * A走完继续走B，长度为a + c + b
 * B走完继续走A，长度为b + c + a
 * 如果有交点，两个肯定会相遇
 *
 *
 * @Author heshang.ink
 * @Date 2019/10/11 21:30
 */
public class 两个链表的第一个公共结点Solution2 {
	public ListNode findFirstCommonNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode pA = headA;
		ListNode pB = headB;
		while (pA != pB) {
			if (pA != null) {
				pA = pA.next;
			} else {
				pA = headB;
			}

			if (pB != null) {
				pB = pB.next;
			} else {
				pB = headA;
			}
//			pA = pA == null ? headB : pA.next;
//			pB = pB == null ? headA : pB.next;
		}
		return pA;

	}
}
