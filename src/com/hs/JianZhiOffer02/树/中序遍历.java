package com.hs.JianZhiOffer02.树;

import com.hs.JianZhiOffer02.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/22 16:51
 * version: 1.0
 */
public class 中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        TreeNode cur = root;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right != null) {
                cur = node.right;
            }
        }
        return ans;
    }
}
