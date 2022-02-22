package com.hs.JianZhiOffer02.树;

import com.hs.JianZhiOffer02.TreeNode;

import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * bfs模板，用队列，然后遍历队列
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/2/13 17:08
 * version: 1.0
 */
public class 从上到下打印二叉树 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int size = queue.size(); size > 0; size--) {
                TreeNode poll = queue.poll();
                tmp.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            ans.add(tmp);
        }
        return ans;
    }
}
