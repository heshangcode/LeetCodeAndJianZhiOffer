package com.hs.JianZhiOffer02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/13 21:03
 * version: 1.0
 */
public class 二叉树的深度 {
    public int maxDepth(TreeNode root) {
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

    //public int maxDepth(TreeNode root) {
    //    if (root == null) {
    //        return 0;
    //    }
    //    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    //}
}
