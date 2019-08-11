package com.hs.LeetCode.链表;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路1：遍历链表，当前节点值 > x，给他放到最后一个节点的后面
 *
 * @Author heshang.ink
 * @Date 2019/8/10 17:34
 */
public class LeetCode86分隔链表 {
	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return null;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		//最后节点的位置
		ListNode lastNode = head;
		ListNode cur = dummy;
		//找到最后节点的位置
		while (lastNode.next != null) {
			lastNode = lastNode.next;
		}
		//这里是为了记录最后一个节点，与cur指针遍历到这个节点就停止
		ListNode last = lastNode;
		while (cur != null && cur.next != null && last != cur) {
			//把当前遍历的节点 > x，放到最后去
			if (cur.next.val >= x) {
				ListNode next = cur.next;
				ListNode nextNext = cur.next.next;
				next.next = null;
				lastNode.next = next;
				lastNode = next;
				cur.next = nextNext;
				cur = nextNext;
			} else {
				cur = cur.next;
			}
		}
		return dummy.next;
	}
}
