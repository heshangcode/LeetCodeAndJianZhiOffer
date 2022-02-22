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
    //标记中序遍历
    HashMap<Integer, Integer> map = new HashMap<>();

    // 保留的先序遍历
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return cur(0, 0, inorder.length - 1);
    }

    /**
     * @param pre_root 先序遍历的索引
     * @param in_left 中序遍历的索引
     * @param in_right 中序遍历的索引
     * @return
     */
    public TreeNode cur(int pre_root, int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre_root]);
        Integer idx = map.get(preorder[pre_root]);
        root.left = cur(pre_root + 1, in_left, idx - 1);
        //左子树长度，前序的下标+ 左子树的数量（在中序数组中：根节点下标 - 左边） + 1
        root.right = cur(pre_root + (idx - in_left) + 1,idx + 1,in_right);
        return root;
    }
}
