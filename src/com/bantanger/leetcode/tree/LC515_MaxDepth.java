package com.bantanger.leetcode.tree;


import com.bantanger.leetcode.dynamic_programming.TreeNode;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/6 19:24
 */
public class LC515_MaxDepth {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        int depth = 0; // 记录遍历到节点的深度
        int res = 0; // 记录最大深度

        public int maxDepth(TreeNode root) {
            traverse(root);
            return res;
        }

        private void traverse(TreeNode root) {
            if (root == null) {
                res = Math.max(res, depth); // 到达叶子节点，更新最大深度
                return;
            }
            // 前序位置
            depth++;
            // 递归过程
            traverse(root.left);
            traverse(root.right);
            // 后序位置
            depth--;
        }
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution2 {
        public int maxDepth(TreeNode root) {
            if(root == null) return 0;
            int leftMax = maxDepth(root.left);
            int rightMax = maxDepth(root.right);
            return Math.max(leftMax, rightMax) + 1;
        }
    }
}
