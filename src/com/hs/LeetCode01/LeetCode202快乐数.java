package com.hs.LeetCode01;

import java.util.HashSet;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 * <p>
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 示例: 
 * <p>
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路：首先定义一个Set集合，用来存放计算后的平方和m，如果m在Set中已存在，即进入了死循环，则退出； 如果m不存在Set，则将m放入Set； 直至找到平方和为1或者进入死循环就退出。
 * <p>
 * 作者：shan-29
 * 链接：https://leetcode-cn.com/problems/two-sum/solution/javafei-chang-rong-yi-li-jie-de-si-lu-by-shan-29/
 *
 * @Author heshang.ink
 * @Date 2019/7/31 11:00
 */
public class LeetCode202快乐数 {
	public boolean isHappy(int n) {
		HashSet<Integer> set = new HashSet<>();
		int sum = 0;
		while (true) {
			while (n != 0) {
				sum += Math.pow(n % 10, 2);
				n /= 10;
			}
			if (sum == 1) {
				return true;
			}
			if (set.contains(sum)) {
				return false;
			} else {
				set.add(sum);
				n = sum;
				sum = 0;
			}
		}
	}
}
