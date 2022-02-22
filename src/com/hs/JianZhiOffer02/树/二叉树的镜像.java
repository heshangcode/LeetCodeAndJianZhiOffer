package com.hs.JianZhiOffer02.树;

import com.hs.JianZhiOffer02.TreeNode;

/**
 * 递归，把原来左边的变为右边，反之
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/13 09:08
 * version: 1.0
 */
public class 二叉树的镜像 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
}
