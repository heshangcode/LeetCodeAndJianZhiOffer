package com.hs.JianZhiOffer.树;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
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
 * 输出：[8, 12, 2, 6, 4]
 *
 * 思路：lc 102层次遍历
 *
 * @Author heshang.ink
 * @Date 2019/10/3 11:18
 */
public class 从上往下打印二叉树 {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if(root == null) return res;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();

			for(int i = 0;i< size;i++){
				TreeNode pop = queue.poll();
				res.add(pop.val);
				if(pop.left != null) queue.add(pop.left);
				if(pop.right != null) queue.add(pop.right);
			}
		}
		return res;

	}
}
