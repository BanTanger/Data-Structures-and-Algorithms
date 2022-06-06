package com.bantanger.leetcode.tree;

import com.bantanger.leetcode.dynamic_programming.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/6 19:22
 */
public class LC687 {
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
        private int maxCount = 0;

        public int longestUnivaluePath(TreeNode root) {
            if (root == null) return 0;
            // 找最长路径
            helper(root, root.val);
            return maxCount;
        }

        // dfs定义：寻找当前节点左右子树的最长路径
        // 添加参数val，及时记录当前节点的值
        private int helper(TreeNode root, int val) {
            // base case
            if (root == null) return 0;
            // 分解子问题
            int leftMax = helper(root.left, root.val); // 递归寻找左子树的最长路径
            int rightMax = helper(root.right, root.val); // 递归寻找右子树的最长路径
            maxCount = Math.max(leftMax + rightMax, maxCount);
            // 当前节点与当前的父节点相同才能返回
            // 补充递归dfs的定义
            if (root.val == val) return Math.max(rightMax, leftMax) + 1;
            return 0;
        }
    }

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(1, null, null);
        TreeNode treeNode2 = new TreeNode(5, null, null);
        TreeNode treeNode3 = new TreeNode(1, null, null);
        TreeNode treeNode4 = new TreeNode(5, null, treeNode2);
        TreeNode treeNode5 = new TreeNode(4, treeNode3, treeNode);
        TreeNode treeNode6 = new TreeNode(5, treeNode5, treeNode4);
        new Solution().longestUnivaluePath(treeNode6);
    }
}
