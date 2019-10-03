package com.hs.JianZhiOffer.树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数按照之字形顺序从上向下打印二叉树。
 * <p>
 * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * <p>
 * 样例
 * 输入如下图所示二叉树[8, 12, 2, null, null, 6, 4, null, null, null, null]
 * 8
 * / \
 * 12  2
 * / \
 * 6   4
 * 输出：[[8], [2, 12], [6, 4]]
 *
 * @Author heshang.ink
 * @Date 2019/10/3 11:37
 */
public class 之字形打印二叉树 {
	public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (root == null) return res;
		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(root);
		//记录是否反转
		boolean isRevese = false;
		while (!queue.isEmpty()) {
			int size = queue.size();
			ArrayList<Integer> list = new ArrayList<>();

			for (int i = 0; i < size; i++) {
				TreeNode pop = queue.poll();

				list.add(pop.val);
				if (pop.left != null) queue.add(pop.left);
				if (pop.right != null) queue.add(pop.right);
			}
			//控制是否需要反转
			if (isRevese) {
				Collections.reverse(list);
				res.add(list);
			} else {
				res.add(list);
			}
			isRevese = !isRevese;
		}
		return res;
	}
}
