package com.hs.JianZhiOffer.链表;

/**
 * 请实现一个函数可以复制一个复杂链表。
 *
 * 在复杂链表中，每个结点除了有一个指针指向下一个结点外，还有一个额外的指针指向链表中的任意结点或者null。
 *
 * 注意：
 *
 * 函数结束后原链表要与输入时保持一致。
 *
 * 思路：https://www.acwing.com/video/172/
 * @Author heshang.ink
 * @Date 2019/10/3 15:21
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class 复杂链表的复刻 {

	public RandomListNode Clone(RandomListNode head) {
		if (head == null) {
			return null;
		}

		RandomListNode p = head;
		//把每个结点的节点复制到这个结点的后面,
		// 比如 1,2,3,4,5,6  改为1,1,2,2,3,3,4,4,5,5,6,6
		while (p != null) {
			RandomListNode node = new RandomListNode(p.label);
			RandomListNode temp = p.next;
			p.next = node;
			node.next = temp;
			p = temp;
		}
		//把random改了，比如1指向4，变为1的复制指向4的复制
		RandomListNode q = head;
		while (q != null) {
			if (q.random != null) {
				q.next.random = q.random.next;
			}
			q = q.next.next;
		}


		//返回结果，把链表里的复制的值提出来
		RandomListNode newHead = new RandomListNode(-1);
		RandomListNode k = newHead;
		RandomListNode m = head;
		while (m != null) {
			k.next = m.next;
			k = k.next;
			m.next = m.next.next;
			m = m.next;
		}
		return newHead.next;
	}
}
