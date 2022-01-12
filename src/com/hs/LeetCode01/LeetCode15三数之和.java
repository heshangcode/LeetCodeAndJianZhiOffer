package com.hs.LeetCode01;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路：对撞指针 + 查找表相关问题
 * 标签：数组遍历
 * 首先对数组进行排序，排序后固定一个数nums[i]nums[i]，再使用左右指针指向nums[i]nums[i]后面的两端，数字分别为nums[L]nums[L]和nums[R]nums[R]，计算三个数的和sumsum判断是否满足为 00，满足则添加进结果集
 * 如果nums[i]nums[i]大于 00，则三数之和必然无法等于 00，结束循环
 * 如果nums[i]nums[i] == nums[i-1]nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
 * 当sumsum == 00 时，nums[L]nums[L] == nums[L+1]nums[L+1]则会导致结果重复，应该跳过，L++L++
 * 当sumsum == 00 时，nums[R]nums[R] == nums[R-1]nums[R−1]则会导致结果重复，应该跳过，R--R−−
 * 时间复杂度：O(n^2)O(n
 * 2
 * )，nn为数组长度
 * https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
 *
 * @Author heshang.ink
 * @Date 2019/8/1 11:00
 */
public class LeetCode15三数之和 {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length < 3) {
			return res;
		}
		//从小到大排序，为了方便去重
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			//为了保证不加入重复的 list,因为是有序的，所以如果和前一个元素相同，只需要继续后移就可以
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				if (nums[i] > 0) {
					//如果最小的都大于0了，3数之和必 > 0
					return res;
				}
				int l = i + 1, r = nums.length - 1;
				while (l < r) {
					int sum = nums[i] + nums[l] + nums[r];
					if (sum == 0) {
						res.add(Arrays.asList(nums[i], nums[l], nums[r]));
						//元素相同要后移，防止加入重复的list
						while (l < r && nums[l] == nums[l + 1]) {
							l++;
						}
						while (l < r && nums[r] == nums[l - 1]) {
							r--;
						}
						l++;
						r--;
					} else if (sum < 0) {
						l++;
					} else if (sum > 0) {
						r--;
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
	}
}
