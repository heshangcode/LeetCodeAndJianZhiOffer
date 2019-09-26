package com.hs.JianZhiOffer.字符串;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 *
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 *
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 *
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配。
 *
 * 样例
 * 输入：
 *
 * s="aa"
 * p="a*"
 *
 * 输出:true
 *
 * 暴力：
 * 以下情况：
 * 1.两字符相等
 * 2.字符串不等，a与.为true，a与*找 ，a与b不等，看后面有没有*，没有为false，有true，下次跳过两步
 *
 * @Author heshang.ink
 * @Date 2019/9/25 20:04
 */
public class 正则表达式匹配 {
	/*public boolean match(char[] str, char[] pattern) {

	}*/
}
