package com.bantanger.leetcode.Question_of_the_day.may.data_2022_05_24;

import com.bantanger.leetcode.dynamic_programming.TreeNode;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/24 9:14
 */
public class LC965 {
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
        int pre;

        public boolean isUnivalTree(TreeNode root) {
            pre = root.val;
            return helper(root);
        }

        private boolean helper(TreeNode root) {
            if (root == null) return true;
            if (pre != root.val) {
                return false;
            }
            pre = root.val;
            return helper(root.left)
                    && helper(root.right);
        }
    }
}
