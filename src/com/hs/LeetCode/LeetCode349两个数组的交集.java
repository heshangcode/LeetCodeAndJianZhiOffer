package com.hs.LeetCode;

import java.util.HashSet;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路：利用set，存储不同的元素性质
 * 可以思考用treeset
 * @Author heshang.ink
 * @Date 2019/7/31 9:35
 */
public class LeetCode349两个数组的交集 {
	public int[] intersection(int[] nums1, int[] nums2) {
		/**
		 *思路：利用Set
		 */
		int[] res;
		HashSet<Integer> record = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			record.add(nums1[i]);
		}
		HashSet<Integer> resultSet = new HashSet<>();
		for (int i = 0; i < nums2.length; i++) {
			if (record.contains(nums2[i])) {
				resultSet.add(nums2[i]);
			}
		}
		res = new int[resultSet.size()];
		int index = 0;
		for (Integer num : resultSet) {
			res[index++] = num;
		}
		return res;

	}
}
