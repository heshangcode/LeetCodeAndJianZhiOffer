package com.hs.JianZhiOffer.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印到一行。
 *
 * 样例
 * 输入如下图所示二叉树[8, 12, 2, null, null, 6, null, 4, null, null, null]
 *     8
 *    / \
 *   12  2
 *      /
 *     6
 *    /
 *   4
 *
 * 输出：[[8], [12, 2], [6], [4]]
 *
 * @Author heshang.ink
 * @Date 2019/10/3 11:36
 */
public class 把二叉树打印多行 {
	ArrayList<ArrayList<Integer>> Print(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(root == null) return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()){
			int size = queue.size();
			ArrayList<Integer> list = new ArrayList<>();

			for(int i = 0; i < size ;i ++){
				TreeNode pop = queue.poll();
				list.add(pop.val);

				if(pop.left != null) queue.add(pop.left);
				if(pop.right != null) queue.add(pop.right);
			}
			res.add(list);
		}
		return res;
	}
}
