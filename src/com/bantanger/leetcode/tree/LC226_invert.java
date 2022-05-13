package com.bantanger.leetcode.tree;

import com.bantanger.leetcode.dynamic_programming.TreeNode;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/13 14:04
 */
public class LC226_invert {
    class Solution2 {
        // 定义invertTree含义是翻转root为根的左右子树，并且返回翻转后的整颗二叉树的根节点
        public TreeNode invertTree(TreeNode root) {
            if(root == null) return null;

            // 利用函数定义，先翻转左右子树
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);

            // 翻转左右子树 == invertTree(root);
            root.left = right;
            root.right = left;

            // 和定义逻辑自恰：以 root 为根的这棵二叉树已经被翻转，返回 root
            return root;
        }
    }

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            traverse(root);
            return root;
        }
        private void traverse(TreeNode root){
            if(root == null) return;
            TreeNode temp;
            temp = root.left;
            root.left = root.right;
            root.right = temp;
            traverse(root.left);
            traverse(root.right);
        }
    }
}
