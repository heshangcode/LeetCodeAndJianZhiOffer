package com.hs.JianZhiOffer;

/**
 * 思路2：用StringBuffer的方法
 *
 * @Author heshang.ink
 * @Date 2019/9/23 18:04
 */
public class 替换空格Solution2 {
	public String replaceSpace(StringBuffer str) {
		StringBuffer st = str;
		for (int i = 0; i < st.length(); i++) {
			if (st.charAt(i) == ' ') {
				//删除这个字符
				st.deleteCharAt(i);
				//加入
				st.insert(i, "%20");
			}
		}
		return st.toString();
	}
}
