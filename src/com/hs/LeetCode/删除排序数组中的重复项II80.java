package com.hs.LeetCode;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [1,1,1,2,2,3],
 * <p>
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：[0,k]保存有效的数据，把当前快指针指向的值和他前面两个数据做比较，必须两个不相同，才下一个，否则就是有效数据
 * @Author heshang.ink
 * @Date 2019/7/24 18:10
 */
public class 删除排序数组中的重复项II80 {
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int k = 1;
		for (int i = 2; i < nums.length; i++) {
			//num[i]和他前面两个数进行比较
			if (nums[k] != nums[i] || nums[k - 1] != nums[i]) {
				nums[++k] = nums[i];
			}
		}
		return k+1;
		/*int p = nums[0];
		int k = 1;
		int j = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != p) {
				nums[k++] = nums[i];
				p = nums[i];
				j = 1;
			} else {
				j++;
				if (j == 2) {
					nums[k++] = nums[i];
				}
			}
		}
		return k;*/

	}

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1,1,1}));
	}
}
