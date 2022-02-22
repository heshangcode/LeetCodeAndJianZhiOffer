package com.hs.JianZhiOffer02;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/13 09:16
 * version: 1.0
 */
public class 对称的二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : cur(root.left, root.right);
    }

    private boolean cur(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.right.val != right.left.val || left.left.val != right.right.val) {
            return false;
        }
        return cur(left.right, right.left) && cur(left.left, right.right);
    }
}
