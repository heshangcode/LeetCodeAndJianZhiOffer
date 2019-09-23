package com.hs.JianZhiOffer;

/**
 * 思路1：直接用replace方法
 *
 * @Author heshang.ink
 * @Date 2019/9/23 18:04
 */
public class 替换空格Solution1 {
	public String replaceSpace(StringBuffer str) {
		return str.toString().replaceAll(" ", "%20");
	}
}
