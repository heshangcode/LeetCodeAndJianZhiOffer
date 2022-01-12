package com.hs.LeetCode01;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *  思路1：双指针法，k和i，[0,k]保存无重复的数字，空间是O(1)，时间是O(n)
 *  思路2：用hashset来去重，时间和空间都是O(n)
 * @Author heshang.ink
 * @Date 2019/7/24 17:32
 */
public class 删除排序数组中的重复项26 {

	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int k = 0;  //[0,k]保存无重复项
		for (int i = 1; i < nums.length; i++) {
			if (nums[k] != nums[i]) {
				//这里得注意是++k
				nums[++k] = nums[i];
			}
		}
		return k + 1;
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1, 1, 2}));
	}
}
