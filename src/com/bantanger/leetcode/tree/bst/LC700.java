package com.bantanger.leetcode.tree.bst;

import com.bantanger.leetcode.dynamic_programming.TreeNode;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/15 9:00
 */
public class LC700 {
    class Solution3 {
        public TreeNode searchBST(TreeNode root, int val) {
            // 由于二叉搜索树的特殊性，所以不需要用栈模拟深度遍历，用队列模拟广度遍历
            while(root != null){
                if(root.val > val) root = root.left;
                else if (root.val < val) root = root.right;
                else return root; // root.val == val;
            }
            return null;
        }
    }
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            return helper(root, val);
        }
        private TreeNode helper(TreeNode root, int val) {
            if(root == null) return null;
            if(root.val == val) return root;
            TreeNode left = helper(root.left, val);
            TreeNode right = helper(root.right, val);
            return left == null ? right : left;
        }
    }
    class Solution2 {
        public TreeNode searchBST(TreeNode root, int val) {
            // 由于二叉搜索树的特殊性，所以不需要用栈模拟深度遍历，用队列模拟广度遍历
            while(root != null){
                if(root.val > val) root = root.left;
                else if (root.val < val) root = root.right;
                else return root; // root.val == val;
            }
            return null;
        }
    }
}
