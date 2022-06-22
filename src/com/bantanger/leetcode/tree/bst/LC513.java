package com.bantanger.leetcode.tree.bst;

import com.bantanger.leetcode.dynamic_programming.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/22 11:05
 */
public class LC513 {
    class Solution {
        public int findBottomLeftValue(TreeNode root) {
            // 层序遍历嘛
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            TreeNode node = null;
            while (!q.isEmpty()) {
                node = q.poll();
                // 从右往左将节点塞入队列，
                // 这样做的目的是为了让队列在弹出元素时，
                // 队列尾部为最底层最左边
                if (node.right != null) q.offer(node.right);
                if (node.left != null) q.offer(node.left);
            }
            return node.val; // 此时的node为二叉树最底层最左边
        }
    }
}
