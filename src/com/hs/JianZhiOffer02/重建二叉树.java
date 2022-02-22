package com.hs.JianZhiOffer02;

import java.util.HashMap;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/12 20:51
 * version: 1.0
 */
public class 重建二叉树 {
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return cur(0, 0, inorder.length - 1);
    }

    public TreeNode cur(int pre_root, int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre_root]);
        Integer idx = map.get(preorder[pre_root]);
        root.left = cur(pre_root + 1, in_left, idx - 1);
        root.right = cur(pre_root + (idx - in_left) + 1,idx + 1,in_right);
        return root;
    }
}
