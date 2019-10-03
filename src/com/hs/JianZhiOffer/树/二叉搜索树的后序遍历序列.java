package com.hs.JianZhiOffer.树;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 *
 * 如果是则返回true，否则返回false。
 *
 * 假设输入的数组的任意两个数字都互不相同。
 *
 * 样例
 * 输入：[4, 8, 6, 12, 16, 14, 10]
 *
 * 输出：true
 *
 * 思路：找到根节点，然后根据大小判断找到左右子树
 * 4,8,6,12,16,14,10
 * 10是根节点 比他小的数4,8,6是它的左子树 12,16,14是他的右子树
 * 然后递归
 * @Author heshang.ink
 * @Date 2019/10/3 14:13
 */
public class 二叉搜索树的后序遍历序列 {
	public boolean VerifySquenceOfBST(int[] array) {
		if (array.length == 0) {
			return false;
		}
		return dfs(array, 0, array.length - 1);
	}

	private boolean dfs(int[] array, int start, int end) {
		if (start >= end) {
			return true;
		}
		int root = array[end];
		int k = start;
		//找到左子树的下标界限
		while (k < end && array[k] < root) k++;

		//判断后面是否满足右子树的性质
		for (int i = k; i < end; i++) {
			if (array[i] < root) {
				return false;
			}
		}
		return dfs(array, start, k - 1) && dfs(array, k, end - 1);
	}

}
