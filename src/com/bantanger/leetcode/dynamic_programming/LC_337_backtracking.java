package com.bantanger.leetcode.dynamic_programming;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/12 10:50
 */

public class LC_337_backtracking {
    class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        /*
            out of time!!!
         */
        public int rob(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null && root.right == null) return root.val;
            // 选择偷父节点,情况A
            int val_A = root.val;
            if (root.left != null) val_A += rob(root.left.left) + rob(root.left.right); // 左
            if (root.right != null) val_A += rob(root.right.left) + rob(root.right.right); // 右

            // 选择不偷父节点,情况B
            int val_B = rob(root.left) + rob(root.right);
            return Math.max(val_A, val_B);
        }
    }

    @Test
    public void test(){
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, null, null), null);
        int rob = new Solution().rob(treeNode);
        System.out.println(rob);
    }
}
