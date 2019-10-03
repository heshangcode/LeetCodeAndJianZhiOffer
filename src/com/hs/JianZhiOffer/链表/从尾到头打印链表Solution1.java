package 链表;

import com.hs.JianZhiOffer.链表.ListNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 思路1：遍历链表放入list，然后反转
 *
 * @Author heshang.ink
 * @Date 2019/9/23 18:18
 */
public class 从尾到头打印链表Solution1 {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<>();
		if (listNode == null) {
			return list;
		}
		ListNode p = listNode;
		while (p != null) {
			list.add(p.val);
			p = p.next;
		}
		Collections.reverse(list);
		return list;
	}

}
