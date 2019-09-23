package com.hs.JianZhiOffer;

/**
 * 思路2：2,3,1,0,2,5,3 比如2应该是在下标为2的位置，如果不在就把他移动到下标为2的位置
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * @Author heshang.ink
 * @Date 2019/9/23 16:01
 */
public class 找出数组中重复的数字Solution2 {
	public boolean duplicate(int nums[],int length,int [] duplication) {

		if (nums == null || nums.length == 0) {
			return false;
		}
		//第一步判断不符合要求的数，为下面判断做准备
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > nums.length - 1 || nums[i] < 0) {
				duplication[0] = -1;
				return false;
			}
		}
		//下面判断的nums[i]全部符合要求
		for (int i = 0; i < nums.length; i++) {
			//如果这个数没有放到相应的问题
			while (nums[i] != i) {
				int temp = nums[i];
				//说明位置有
				if (nums[i] == nums[nums[i]]) {
					duplication[0] = temp;
					return true;
				} else {
					//位置交换
					nums[i] = nums[temp];
					nums[temp] = temp;
				}
			}
		}
		return false;

	}
}
