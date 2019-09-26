package com.hs.JianZhiOffer.链表;

/**
 * 给定单向链表的一个节点指针，定义一个函数在O(1)时间删除该结点。
 *
 * 假设链表一定存在，并且该节点一定不是尾节点。
 *
 * 样例
 * 输入：链表 1->4->6->8
 *       删掉节点：第2个节点即6（头节点为第0个节点）
 *
 * 输出：新链表 1->4->8
 *
 * 思路：正常来说删除需要知道之前的结点，但是这个不需要
 * 把删除结点的下一个结点值放进删除结点，然后把下一个节点去掉就ok
 * @Author heshang.ink
 * @Date 2019/9/25 17:20
 */
public class 在O1复杂度删除链表结点 {
	public void deleteNode(ListNode node) {
		if (node == null) {
			return;
		}
		int val = node.next.val;
		node.val = val;
		node.next = node.next.next;
	}

}
