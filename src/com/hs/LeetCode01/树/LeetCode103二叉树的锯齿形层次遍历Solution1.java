package com.hs.LeetCode01.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 请实现一个函数按照之字形顺序从上向下打印二叉树。
 *
 * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * 样例
 * 输入如下图所示二叉树[8, 12, 2, null, null, 6, 4, null, null, null, null]
 *     8
 *    / \
 *   12  2
 *      / \
 *     6   4
 * 输出：[[8], [2, 12], [6, 4]]
 *
 * 思路1：BFS，用一个i计数，i为偶数，把里面那个list反转，然后放进res
 * 或者用一个标识，是addLast还是addFrist
 * @Author heshang.ink
 * @Date 2019/10/3 11:39
 */
public class LeetCode103二叉树的锯齿形层次遍历Solution1 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) return res;
		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(root);
		//记录是否反转
		boolean isRevese = false;
		while(!queue.isEmpty()){
			int size = queue.size();
			LinkedList<Integer> list = new LinkedList<>();

			for(int i = 0; i < size ;i++){
				TreeNode pop = queue.poll();
				if(isRevese){
					list.addFirst(pop.val);
				}else{
					list.add(pop.val);
				}
				if(pop.left != null) queue.add(pop.left);
				if(pop.right != null) queue.add(pop.right);
			}
			//控制是否需要反转
			isRevese = !isRevese;
			res.add(list);
		}
		return res;
	}
}
