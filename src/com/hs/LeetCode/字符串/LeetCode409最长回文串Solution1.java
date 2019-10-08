package com.hs.LeetCode.字符串;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "abccccdd"
 * <p>
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 思路：贪心
 * 回文串是一个正读和反读都一样的字符串。对一个左边的字符 i 右边一定会有一个对称 i。比如 'abcba'， 'aa'，'bb' 这几个回文串。其中第一个有点特殊，中间的 c 是唯一的。
 * <p>
 * 如果让你来造一个回文串你会怎么造？ 首先让它左右两边绝对对称，如果可能的话再加上一个唯一的中心。
 * <p>
 * 算法
 * <p>
 * 对于每个字母，假设它出现了 v 次。我们可以让 v // 2 * 2 个字母左右对称。例如，对于字符串 'aaaaa'，其中 'aaaa' 是左右对称，其长度为 5 // 2 * 2 = 4。
 * <p>
 * 最后，如果有任何一个满足 v % 2 == 1 的 v，那么这个字符就可能是回文串中唯一的那个中心。针对这种情况，我们需要判断 v % 2 == 1 && ans % 2 == 0，后面的判断主要是为了防止重复计算。
 *
 * @Author heshang.ink
 * @Date 2019/10/7 9:10
 */
public class LeetCode409最长回文串Solution1 {
	public int longestPalindrome(String s) {
		int[] count = new int[128];
		//统计每个字符出现次数
		for (char c : s.toCharArray()) {
			count[c]++;
		}

		int ans = 0;
		int center = 0;
		for (int v : count) {
			//出现次数为偶数，则可以构成
			if (v % 2 == 0) {
				ans += v;
			} else {
				//出现奇数，说明有个中心的点
				ans+= v - 1;
				center = 1;
			}
		}
		return ans + center;
	}
}
