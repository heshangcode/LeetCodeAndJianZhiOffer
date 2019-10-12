package com.hs.JianZhiOffer.字符串;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 *
 * 例如，当从字符流中只读出前两个字符”go”时，第一个只出现一次的字符是’g’。
 *
 * 当从该字符流中读出前六个字符”google”时，第一个只出现一次的字符是’l’。
 *
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 * 样例
 * 输入："google"
 *
 * 输出："ggg#ll"
 *
 * 解释：每当字符流读入一个字符，就进行一次判断并输出当前的第一个只出现一次的字符。
 *
 * @Author heshang.ink
 * @Date 2019/10/10 9:44
 */
public class 字符流中第一个只出现一次的字符 {

	//维护只出现一次的字符
	Queue<Character> q = new LinkedList<>();
	//存字符出现的次数
	Map<Character, Integer> map = new HashMap<>();

	//Insert one char from stringstream
	public void insert(char ch){
		//如果包含移除
		if (map.containsKey(ch)) {
			if (q.contains(ch)) {
				q.remove(ch);
			}
			return;
		}
		//加入map和队列
		map.put(ch, 1);
		q.offer(ch);
	}
	//return the first appearence once char in current stringstream
	public char firstAppearingOnce(){
		if (q.isEmpty()) {
			return '#';
		}
		return q.peek();
	}
}
