package com.hs.排序;

import java.util.Arrays;

/**
 * 找到一个值，依次与他前面的值比较，比前面的值小，位置互换，放到相应的位置上
 *
 * @Author heshang.ink
 * @Date 2019/8/21 17:26
 */
public class 插入排序 {
	public static void main(String[] args) {
		int[] arr = new int[]{2, 8, 13, 11, 6, 7};
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void insertSort(int[] nums) {
		//将nums[i] 插入到nums[0]...nums[i - 1]中
		for (int i = 1; i < nums.length; i++) { //插入的次数
			//找到当前值 nums[i]
			int temp = nums[i]; //要插入的数
			//比较前面排序好的值，个人觉得从后面开始比较很不错
			int j = i - 1;  //已经排序好的序列元素个数
			while (j >= 0 && temp < nums[j]) {  //序列从后到前循环，将大于temp的数向后移动一格
				//这里就是相当于
				//比如temp = 11，11 < 13，把13->11位置，
				nums[j + 1] = nums[j];  //元素移动一格
				j--;
			}
			nums[j + 1]=temp;   //将需要插入的数放在要插入的位置。
		}
	}
}
