package com.hs.JianZhiOffer;

/**
 * 双指针法，把字符扩容成改变后的大小，
 * i指向原字符的后面，j指向新的字符的后面，如果不是空就复制到新的字符后面
 *
 * @Author heshang.ink
 * @Date 2019/9/23 18:10
 */
public class 替换空格Solution3 {
	public String replaceSpace(StringBuffer str) {
		int len = str.length();
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == ' ') {
				str.append("   ");  //3个空格就是 %20的位置
			}
		}
		int oldLen = len - 1;
		int newLen = str.length() - 1;
		int i = oldLen, j = newLen;
		while (i >= 0 && j >= 0) {
			if (str.charAt(i) == ' ') {
				str.setCharAt(j--, '0');
				str.setCharAt(j--, '2');
				str.setCharAt(j--, '%');
			} else {
				str.setCharAt(i--, str.charAt(i));
				j--;
			}
		}
		return str.toString();
	}
}
