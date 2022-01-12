package com.hs.LeetCode01;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/7/2 14:39
 */
public class 最长公共前缀14 {
	public String longestCommonPrefix(String[] strs) {
		/**
		 * 思路：水平扫描法，假设第一个字符串为公共前缀，然后遍历用indexOf去匹配其他字符串，如果匹配不到，把公共串缩小
		 */
		if(strs.length == 0) return "";
		//公共前缀
		String prefix = strs[0];
		for(int i = 1; i < strs.length; i++){
			//遍历比较其他串开始是否这些字符串
			while(strs[i].indexOf(prefix) != 0){
				//如果开始不是第一个表示，不是公共前缀，缩小公共前缀的范围
				prefix = prefix.substring(0, prefix.length() - 1);
				if("".equals(prefix)) return "";
			}
		}
		return prefix;
	}
}
