package com.hs.JianZhiOffer.字符串;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * <p>
 * 为简单起见，标点符号和普通字母一样处理。
 * <p>
 * 例如输入字符串"I am a student."，则输出"student. a am I"。
 * <p>
 * 样例
 * 输入："I am a student."
 * <p>
 * 输出："student. a am I"
 * 思路：
 * 1. 翻转整个句子
 * 2. 然后翻转每个单词，然后拼一起
 * <p>
 * 1 2 顺序可以变换，也可以先2再1
 *
 * @Author heshang.ink
 * @Date 2019/10/13 10:30
 */
public class 翻转单词顺序Solution2 {

	public String reverseWords1(String s) {
		if (s == null)
			return "";
		s = s.trim();
		if (s.length() == 0)
			return s;

		String[] strs = s.split(" ");
		int len = strs.length;
		for (int i = 0; i < len / 2; i++) {
			String tmp = strs[i];
			strs[i] = strs[len - i - 1];
			strs[len - i - 1] = tmp;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len - 1; i++) {
			sb.append(strs[i]).append(" ");
		}
		sb.append(strs[len - 1]);

		return sb.toString();
	}

}
