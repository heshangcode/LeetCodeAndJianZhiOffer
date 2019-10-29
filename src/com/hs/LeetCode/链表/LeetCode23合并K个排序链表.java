package com.hs.LeetCode.链表;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 时间 ：O(kN)
 * 空间：O(1)
 * @Author heshang.ink
 * @Date 2019/10/29 9:14
 */
public class LeetCode23合并K个排序链表 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode h = new ListNode(0);
		ListNode ans=h;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				h.next = l1;
				h = h.next;
				l1 = l1.next;
			} else {
				h.next = l2;
				h = h.next;
				l2 = l2.next;
			}
		}
		if(l1==null){
			h.next=l2;
		}
		if(l2==null){
			h.next=l1;
		}
		return ans.next;
	}
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length==1){
			return lists[0];
		}
		if(lists.length==0){
			return null;
		}
		ListNode head = mergeTwoLists(lists[0],lists[1]);
		for (int i = 2; i < lists.length; i++) {
			head = mergeTwoLists(head,lists[i]);
		}
		return head;
	}
}
