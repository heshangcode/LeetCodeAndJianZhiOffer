package com.hs.LeetCode01.链表;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路：找到mNode和nNode，把mNode放到nNode后面
 * @Author heshang.ink
 * @Date 2019/8/10 15:10
 */
public class LeetCode92反转链表II {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m > n) {
			return null;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode mNode = head;
		ListNode nNode = head;
		ListNode preM = dummy;
		//找到mNode
		for (int i = 1; i < m; i++) {
			preM = mNode;
			mNode = mNode.next;
		}
		//找到nNode
		for (int i = 1; i < n; i++) {
			nNode = nNode.next;
		}
		//把mNode放到nNode后面
		while (mNode != nNode) {
			preM.next = mNode.next;
			mNode.next = nNode.next;
			nNode.next = mNode;
			mNode = preM.next;
		}
		return dummy.next;
	}
}
