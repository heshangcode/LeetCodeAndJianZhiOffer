package com.hs.LeetCode.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 思路1：https://www.youtube.com/watch?v=B0n3gqPKKic&t=308s
 * 经典层次遍历模板 BFS
 * 一个queue存放当前层的节点，然后pop出来，把pop出来的值他的左右子树值再放入queue
 * 思路2：DFS
 * https://leetcode.wang/leetcode-102-Binary-Tree-Level-Order-Traversal.html
 *
 * @Author heshang.ink
 * @Date 2019/8/16 16:20
 */
public class LeetCode102二叉树的层次遍历 {
	public List<List<Integer>> levelOrder1(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}
		//LinkedList也是Queue的实现
		LinkedList<TreeNode> queue = new LinkedList<>();
		//把第一层的放进去
		queue.add(root);    //放3
		//遍历queue，把下一层的放入
		while (!queue.isEmpty()) {
			//size 1
			//size 2
			int size = queue.size();
			ArrayList<Integer> list = new ArrayList<>();
			//把这一层的pop出来，同时加入他的下一层
			for (int i = 0; i < size; i++) {
				//3 pop
				//9 pop     20 pop
				TreeNode node = queue.pop();
				list.add(node.val);
				//加入pop出来的下一层   加入3的下一层左右子树
				if (node.left != null) {
					//add 9
					// 9.left is 15   20.left is null
					queue.add(node.left);
				}
				if (node.right != null) {
					//add 10
					//add 9.right is null       20.right is 7
					queue.add(node.right);
				}
				//queue:9 10
			}
			//list:3
			//9 20
			ans.add(list);

		}
		return ans;
	}

	public List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		DFS(root, 0, ans);
		return ans;
	}

	private void DFS(TreeNode root, int level, List<List<Integer>> ans) {
		if (root == null) {
			return;
		}
		//当前层数还没有元素，先 new 一个空的列表
		if (ans.size() <= level) {
			ans.add(new ArrayList<Integer>());
		}
		//当前值加入
		ans.get(level).add(root.val);

		//左右子树
		DFS(root.left, level + 1, ans);
		DFS(root.right, level + 1, ans);
	}
}
