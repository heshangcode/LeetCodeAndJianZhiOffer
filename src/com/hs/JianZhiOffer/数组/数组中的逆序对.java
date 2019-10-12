package com.hs.JianZhiOffer.数组;

import java.util.Arrays;

/**
 * 在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * <p>
 * 输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * 样例
 * 输入：[1,2,3,4,5,6,0]
 * <p>
 * 输出：6
 * <p>
 * 暴力，超时过不了
 * 首先想到的暴力一定不是面试官想要的，暴力的复杂度为n平方
 * 那么比暴力更快一点的复杂度为nlogn，怎么才会有logn出现呢
 * 一半一半就会有logn出现
 * 怎么样把一半一半用到这道题上呢
 * 将数组[1,2,3,4,5,6,0]对半切，变成arr1=[1,2,3,4]和arr2=[5,6,0]
 * 将arr1里的1和arr2的5做比较，发现1<5，要是arr2里的0是7或者8就好了，这样1就比arr2里的所有数字都小了呢，就不存在逆序对了
 * 那么假设arr2排过序了是[0,5,6],刚好arr1目前也是排过序的
 * 1、arr1里的1是大于arr2里的0的，那么arr1里1且其之后的所有数字都比0大，则对于0来说，有4个数字比它大，所以结果变量+4,
 * 0被arr1里的所有数字都比较过了（也不是一个个遍历比较，而是用了有序的性质），0就可以被丢弃了（实际上是放到归并排序的临时数组里了）
 * 2、此时1是小于5的，那么可以断定1比arr2里的所有数字都小，也可以把1和之前的0一样处理掉
 * 3、现在arr1=[2,3,4] arr2=[5,6],2小于5，所以2比arr2里的都要小，丢弃，一直循环下去，4也被丢掉，逆序对完成
 * <p>
 * 所以解法就是归并排序，只加了一行res+=mid-i+1;
 * 递归里面运行完两个mergeSort后，start~mid 和 mid+1~end都是有序的，且两个内部的逆序对都已经算过了，只需要算当前状态的逆序对就行了，不会重复的
 * <p>
 * 作者：脆脆鲨
 * 链接：https://www.acwing.com/solution/acwing/content/1724/
 * 来源：AcWing
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @Author heshang.ink
 * @Date 2019/10/10 10:03
 */
public class 数组中的逆序对 {
	int res = 0;

	public int inversePairs(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return 0;
		}
		int start = 0, end = nums.length - 1;
		mergeSort(nums, start, end);
		return res;
	}

	private void mergeSort(int[] nums, int start, int end) {
		if (start >= end) return;
		int mid = start + (end - start) / 2;
		mergeSort(nums, start, mid);
		mergeSort(nums, mid + 1, end);
		merge(nums, start, mid, end);
	}

	private void merge(int[] nums, int left, int mid, int right) {
		int[] temp = new int[right - left + 1];
		int i = left;
		int j = mid + 1;
		int index = 0;
		while (i <= mid && j <= right) {
			if (nums[i] <= nums[j]) {
				temp[index++] = nums[i++];
			} else {
				temp[index++] = nums[j++];
				//这里变化了
				res = (res + (mid - i + 1)) % 1000000007;
			}
		}
		while (i <= mid) {
			temp[index++] = nums[i++];
		}
		while (j <= right) {
			temp[index++] = nums[j++];
		}
		for (int k = 0; k < temp.length; k++) {
			nums[k + left] = temp[k];
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[]{2, 8, 13, 11, 6, 7};
		System.out.println("归并排序前：" + Arrays.toString(arr));
		new 数组中的逆序对().mergeSort(arr, 0, arr.length - 1);
		System.out.println("归并排序后：" + Arrays.toString(arr));
	}
}
