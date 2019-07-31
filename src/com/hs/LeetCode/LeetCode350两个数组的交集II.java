package com.hs.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路：利用map<key,value> value存放这个值出现的次数
 *  这里其实可以用treemap
 * @Author heshang.ink
 * @Date 2019/7/31 9:39
 */
public class LeetCode350两个数组的交集II {
	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> record = new HashMap<>();
		for (int num : nums1) {
			//先查看record是否有num这个值，没有给赋值为1
			if (!record.containsKey(num)) {
				record.put(num, 1);
			} else {
				record.put(num, record.get(num) + 1);
			}
		}
		ArrayList<Integer> resList = new ArrayList<>();
		for (int num : nums2) {
			//这里record.containsKey(num)是个小坑，不先判断，后面会出现NullPointerException
			if (record.containsKey(num) && record.get(num) > 0) {
				resList.add(num);
				record.put(num, record.get(num) - 1);
			}
		}
		int[] res = new int[resList.size()];
		for (int i = 0; i < resList.size(); i++) {
			res[i] = resList.get(i);
		}
		return res;
	}
}
