package com.hs.LeetCode;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/4/29 18:34
 */
public class 验证栈序列 {
	public static void main(String[] args) {

	}

	/*public boolean validateStackSequences(int[] pushed, int[] popped) {
		if (pushed.length != popped.length) {
			return false;
		}
		if (pushed.length == 0) {
			return true;
		}
		Stack<Integer> stack = new Stack<>();
		//popped数组的下标
		int popIndex = 0;
		//pushed数组的下标
		int i = 0;
		while (i < pushed.length){
			if (pushed[i] == popped[popIndex]) {
				//要入栈的元素是将要popped的数字
				//popped数组下标++，pushed数组下标++
				popIndex++;
				i++;
			} else if (!stack.isEmpty() && (stack.peek() == popped[popIndex])) {
				//此时栈顶是poped要出的数字，把这个栈顶的值pop出来，popped数组下标++
				stack.pop();
				popIndex++;
			} else {
				//要入栈的元素不是popped的数字
				//进行入栈
				stack.push(pushed[i]);
				i++;
			}
		}
		//说明栈里还有数据，popped数组里还有值，再进行一次判断
		while (!stack.isEmpty() && popIndex < popped.length) {
			if (stack.peek() != popped[popIndex]) {
				return false;
			} else {
				stack.pop();
				popIndex++;
			}
		}
		return true;
	}*/
}
