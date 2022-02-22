package com.hs.JianZhiOffer02.树;

import com.hs.JianZhiOffer02.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1：递归左右子树，每次最大值+1
 * 2：层次遍历，每层+1
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/13 21:03
 * version: 1.0
 */
public class 二叉树的深度 {
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res++;
        }
        return res;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
