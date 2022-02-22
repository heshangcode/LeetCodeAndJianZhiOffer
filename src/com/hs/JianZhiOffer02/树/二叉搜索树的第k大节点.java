package com.hs.JianZhiOffer02.树;

import com.hs.JianZhiOffer02.TreeNode;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;

/**
 * 利用中序遍历
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/15 08:37
 * version: 1.0
 */
public class 二叉搜索树的第k大节点 {
    int res, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        zhong(root);
        return res;
    }

    public void zhong(TreeNode root) {
        if (root == null) {
            return;
        }
        zhong(root.right);
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            res = root.val;
        }
        zhong(root.left);
    }
}
