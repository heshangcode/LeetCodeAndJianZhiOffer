package com.hs.LeetCode.位运算;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：
 * 1.位运算求解此题;
 * 2.如果把所有出现三次的数字的二进制表示的每一位加起来,那么每一位都能被3整除;
 * 3.如果某一位的和能被3整除,那么只出现一次数字的二进制位中对应的那一位就是0,否则就是1;
 * 4.完结。
 *
 * 作者：spirit-9
 * 链接：https://leetcode-cn.com/problems/single-number-ii/solution/java-yi-dong-yi-jie-xiao-lu-gao-by-spirit-9-8/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @Author heshang.ink
 * @Date 2019/10/13 8:51
 */
public class LeetCode137只出现一次的数字IISolution1 {
	public int singleNumber(int[] nums) {
		int[] bit = new int[32];
		for (int j = 0; j < 32; j++) {
			for (int i = 0; i < nums.length; i++) {
				int num = nums[i] >> j;
				bit[j] += num & 1;
			}
		}

		int res = 0;
		for (int i = 31; i >= 0; i--) {
			res <<= 1;
			res += bit[i] % 3;
		}
		return res;
	}
}
