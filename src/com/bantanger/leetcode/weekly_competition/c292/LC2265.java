package com.bantanger.leetcode.weekly_competition.c292;

import com.bantanger.leetcode.dynamic_programming.TreeNode;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/25 13:24
 */
public class LC2265 {
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
    class Solution {
        int res = 0;
        int num = 0;
        public int averageOfSubtree(TreeNode root) {
            dfs(root);
            return res;
        }
        private int dfs(TreeNode root) {
            if(root == null) return 0;
            int currcount = num;
            num++;
            int sum = dfs(root.left) + dfs(root.right) + root.val;
            if(root.val == sum / (num - currcount)) res++;
            return sum;
        }
    }
}
