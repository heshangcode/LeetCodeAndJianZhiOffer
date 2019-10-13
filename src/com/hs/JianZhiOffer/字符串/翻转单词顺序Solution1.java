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
public class 翻转单词顺序Solution1 {
	public String reverseWords(String s) {
		if (s == null || s.trim().length() == 0) return s;
		String reverseAll = reverseAll(s);
		String res = reverseWord(reverseAll.split(" "));
		return res.substring(0, res.length() - 1);
	}

	/**
	 * 翻转传过来的s字符串
	 *
	 * @param s
	 * @return
	 */
	private String reverseAll(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	/**
	 * 逆序每个单词
	 *
	 * @param splits
	 * @return
	 */
	public String reverseWord(String[] splits) {
		StringBuilder sb = new StringBuilder();
		for (String s : splits) {
			sb.append(reverseAll(s));
			//小心注意最后不要忘记加空格
			sb.append(" ");
		}
		return sb.toString();
	}

}
