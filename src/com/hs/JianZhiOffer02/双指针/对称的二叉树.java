package com.hs.JianZhiOffer02.双指针;

import com.hs.JianZhiOffer02.TreeNode;

/**
 * dfs，规律：左子树.right = 右子树.left
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/13 09:16
 * version: 1.0
 */
public class 对称的二叉树 {
    //public boolean isSymmetric(TreeNode root) {
    //    return root == null ? true : cur(root.left, root.right);
    //}
    //
    //private boolean cur(TreeNode left, TreeNode right) {
    //    if (left == null && right == null) {
    //        return true;
    //    }
    //    if (left == null || right == null || left.val != right.val) {
    //        return false;
    //    }
    //    return cur(left.right, right.left) && cur(left.left, right.right);
    //}

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.right, root.left);
    }

    private boolean dfs(TreeNode right, TreeNode left) {
        if (right == null && left == null) {
            return true;
        }
        if (right == null || left == null
                || right.val != left.val) {
            return false;
        }
        return dfs(right.left, left.right) && dfs(right.right, left.left);
    }
}
