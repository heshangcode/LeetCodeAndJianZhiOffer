package com.hs.LeetCode01.栈;

import java.util.Stack;

/**
 * 给定 pushed 和 popped 两个序列，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 * <p>
 * 链接：https://leetcode-cn.com/problems/validate-stack-sequences
 * <p>
 * 思路：进入栈可能在某个时间又出栈了
 *
 * @Author heshang.ink
 * @Date 2019/10/3 10:58
 */
public class LeetCode946验证栈序列 {
	public boolean validateStackSequences(int[] pushed, int[] popped) {
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
		}
		//全部压入了，再慢慢弹出，再次判断
		while (!stack.isEmpty()) {
			if (stack.peek() == popped[j]) {
				j++;
				stack.pop();
			} else {
				return false;
			}

		}
		return stack.isEmpty();

	}
}
