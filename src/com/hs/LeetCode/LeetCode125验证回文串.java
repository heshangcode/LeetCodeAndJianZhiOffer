package com.hs.LeetCode;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路1：对撞指针，左右两个指针比较，首先把所有字母变为小写或者大写
 * 只考虑字母和数字，
 *
 * @Author heshang.ink
 * @Date 2019/7/29 17:32
 */
public class LeetCode125验证回文串 {
	public static boolean isPalindrome(String s) {
		if (s.length() == 0) {
			return true;
		}
		s = s.toLowerCase();
		System.out.println(s);
		char[] chars = s.toCharArray();
		int l = 0, r = chars.length - 1;
		while (l <= r) {
			if (!(chars[l] >= 'a' && chars[l] <= 'z' || chars[l] >= '0' && chars[l] <= '9')) {
				l++;
			} else if (!(chars[r] >= 'a' && chars[r] <= 'z' || chars[r] >= '0' && chars[r] <= '9')) {
				r--;
			} else if (chars[l] == chars[r]) {
				l++;
				r--;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("0P"));
	}
}
