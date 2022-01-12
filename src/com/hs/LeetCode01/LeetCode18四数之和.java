package com.hs.LeetCode01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路：在三数之和上多加了一个for循环
 * 对撞指针 + 查找表相关问题
 *
 * @Author heshang.ink
 * @Date 2019/8/1 14:49
 */
public class LeetCode18四数之和 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length < 4) {
			return res;
		}
		Arrays.sort(nums);
		//多加一层
		for (int i = 0; i < nums.length - 3; i++) {
			//防止重复
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				for (int j = i + 1; j < nums.length - 2; j++) {
					if (j == i + 1 || (nums[j] != nums[j - 1])) {
						int l = j + 1, r = nums.length - 1, sum = target - nums[i] - nums[j];
						while (l < r) {
							if (nums[l] + nums[r] == sum) {
								res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
								while (l < r && nums[l] == nums[l + 1]) {
									l++;
								}
								while (l < r && nums[r] == nums[r - 1]) {
									r--;
								}
								l++;
								r--;
							} else if (nums[l] + nums[r] < sum) {
								l++;
							} else if (nums[l] + nums[r] > sum) {
								r--;
							}

						}
					}

				}
			}

		}
		return res;
	}
}
