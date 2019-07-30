package com.hs.LeetCode.回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

 例如，给出 n = 3，生成结果为：

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/generate-parentheses
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author heshang.ink
 * @Date 2019/6/18 9:44
 */
public class 括号生成22 {
	List<String> ans = new ArrayList<>();
	public List<String> generateParenthesis(int n) {
		/**
		 * 思路，类似验证这个串是否有效括号，判断左右括号的数量
		 */
		if(n == 0){
			return ans;
		}
		dfs(n,"",0,0);
		return ans;
	}
	public void dfs(int n, String path, int left, int right){
		if(left == n && right == n){
			ans.add(path);
			return;
		}
		//如果左括号小于n，则加入左括号
		if(left < n){
			dfs(n,path + "(",left + 1,right);
		}
		//如果右括号小于左括号，则加入右括号
		if(left > right){
			dfs(n,path + ")",left, right + 1);
		}
	}
}
