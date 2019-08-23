package com.hs.LeetCode.树;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * <p>
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 思路：DFS,最直观的方法是使用递归。在递归遍历二叉树时，需要考虑当前的节点和它的孩子节点。
 * 如果当前的节点不是叶子节点，则在当前的路径末尾添加该节点，并递归遍历该节点的每一个孩子节点。
 * 如果当前的节点是叶子节点，则在当前的路径末尾添加该节点后，就得到了一条从根节点到叶子节点的路径，
 * 可以把该路径加入到答案中。
 * 链接：https://leetcode-cn.com/problems/two-sum/solution/er-cha-shu-de-suo-you-lu-jing-by-leetcode/
 *
 * @Author heshang.ink
 * @Date 2019/8/18 18:29
 */
public class LeetCode257二叉树的所有路径 {
	public List<String> binaryTreePaths(TreeNode root) {
		ArrayList<String> res = new ArrayList<>();
		construct_paths(root, "", res);
		return res;
	}

	private void construct_paths(TreeNode root, String path, ArrayList<String> res) {
		if (root == null) {
			return;
		}
		//把当前节点加入到路径中
		path += root.val;
		//说明找到了叶子节点 ,把路径加入到答案中，然后返回
		if (root.left == null && root.right == null) {
			res.add(path);
			return;
		}
		path += "->";
		construct_paths(root.left, path, res);
		construct_paths(root.right, path, res);

	}
}
