package com.hs.LeetCode01.数组;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路：查找表相关问题：
 * 利用map里统计s串中字符出现次数来比较t串
 * 也可以利用数组解决问题
 *
 * @Author heshang.ink
 * @Date 2019/7/31 10:29
 */
public class LeetCode242有效的字母异位词Solution2 {
	public boolean isAnagram(String s, String t) {
		// 因为说了是小写字母，所以用26的数组去存
		int[] sArray = new int[26];
		int[] tArray = new int[26];
		for (char c : s.toCharArray()) {
			sArray[c - 'a']++;
		}
		for (char c : t.toCharArray()) {
			tArray[c - 'a']++;
		}
		//比较啦
		for (int i = 0; i < sArray.length; i++) {
			if (sArray[i] != tArray[i]) {
				return false;
			}
		}
		return true;
	}

}
