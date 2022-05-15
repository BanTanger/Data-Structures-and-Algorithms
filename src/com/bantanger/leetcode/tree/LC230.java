package com.bantanger.leetcode.tree;

import com.bantanger.leetcode.dynamic_programming.TreeNode;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/15 8:22
 */
public class LC230 {
    class Solution {
        int res = 0;
        int rank = 0;
        public int kthSmallest(TreeNode root, int k) {
            helper(root, k);
            return res;
        }
        private void helper(TreeNode root, int k) {
            if(root == null) return ;
            helper(root.left, k);
            rank++;
            if(k == rank) {
                res = root.val;
                return ;
            }
            helper(root.right, k);
        }
    }
}
