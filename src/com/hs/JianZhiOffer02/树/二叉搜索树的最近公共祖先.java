package com.hs.JianZhiOffer02.树;

import com.hs.JianZhiOffer02.TreeNode;

/**
 * 遍历
 *
 * 根据值大小来判断 2 个值是否在左右子树，如果都在一侧，
 * 那就继续向下遍历，如果不再一侧，那说明了分开的 root 就公共祖先。
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/16 08:57
 * version: 1.0
 */
public class 二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }
}
