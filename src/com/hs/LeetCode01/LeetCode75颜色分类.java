package com.hs.LeetCode01;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路1：排序很简单
 * 思路2：计数排序，统计各个数字的多少，然后重组数组，对整个数组遍历了两遍
 * 时间复杂度: O(n)
 * 空间复杂度: O(k), k为元素的取值范围
 * 思路3：三路快排思想
 * 讲解：https://leetcode-cn.com/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode/
 *
 * @Author heshang.ink
 * @Date 2019/7/26 18:55
 */
public class LeetCode75颜色分类 {

	public void sortColors2(int[] nums) {
		int[] count = {0, 0, 0};    //存放0, 1, 2三个元素的频率
		for (int i = 0; i < nums.length; i++) {
			count[nums[i]]++;
		}

		int index = 0;
		for (int i = 0; i < count[0]; i++) {
			nums[index++] = 0;
		}
		for (int i = 0; i < count[1]; i++) {
			nums[index++] = 1;
		}
		for (int i = 0; i < count[2]; i++) {
			nums[index++] = 2;
		}
	}

	public void sortColors3(int[] nums) {
		int zero = -1;  //[0,zero]存0
		int two = nums.length;  //[two,num.length-1]存2
		for (int i = 0; i < two; ) {
			if (nums[i] == 0) {
				zero++;
				swap(nums, zero, i);
				i++;
			} else if (nums[i] == 2) {
				two--;
				swap(nums, i, two);
			} else {
				assert nums[i] == 1;
				i++;
			}

		}
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
