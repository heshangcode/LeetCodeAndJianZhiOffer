package com.hs.JianZhiOffer.栈;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * <p>
 * 假设压入栈的所有数字均不相等。
 * <p>
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * <p>
 * 注意：若两个序列长度不等则视为并不是一个栈的压入、弹出序列。若两个序列都为空，则视为是一个栈的压入、弹出序列。
 * <p>
 * 样例
 * 输入：[1,2,3,4,5]
 * [4,5,3,2,1]
 * <p>
 * 输出：true
 *
 * @Author heshang.ink
 * @Date 2019/10/3 10:52
 */
public class 栈的压入弹出序列 {
	public boolean IsPopOrder(int[] pushed, int[] popped) {
		if (pushed.length != popped.length) {
			return false;
		}
		int i = 0;
		int j = 0;
		Stack<Integer> stack = new Stack<>();
		// 这里就是，1,2,3,4压进去
		while (i < pushed.length) {
			stack.add(pushed[i]);
			//判断每次压进去的值，是不是里面就弹出来了
			if (stack.peek() == popped[j]) {
				j++;
				stack.pop();
			}
			//再次判断是不是把栈里的元素，先弹出来了，没有进行压入
			while (!stack.isEmpty() && stack.peek() == popped[j]) {
				j++;
				stack.pop();
			}
			i++;
		}
		//全部压入了，再慢慢弹出，再次判断
		while (!stack.isEmpty()) {
			if (stack.peek() == popped[j]) {
				j++;
				stack.pop();
			}else {
				return false;
			}
		}
		return stack.isEmpty();
	}
}
