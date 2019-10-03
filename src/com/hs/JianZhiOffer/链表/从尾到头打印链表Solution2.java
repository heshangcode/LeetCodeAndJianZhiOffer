package 链表;

import com.hs.JianZhiOffer.链表.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 思路2：遍历链表放入stack，然后pop出来
 *
 * @Author heshang.ink
 * @Date 2019/9/23 18:18
 */
public class 从尾到头打印链表Solution2 {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		if (listNode == null) {
			return list;
		}
		ListNode p = listNode;
		while (p != null) {
			stack.add(p.val);
			p = p.next;
		}
		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}
		return list;
	}

}
