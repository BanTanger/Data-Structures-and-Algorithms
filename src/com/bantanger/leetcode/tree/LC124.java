package com.bantanger.leetcode.tree;

import com.bantanger.leetcode.dynamic_programming.TreeNode;
import org.junit.jupiter.api.Test;
import sun.reflect.generics.tree.Tree;

import javax.sound.midi.Soundbank;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/6 16:44
 */
public class LC124 {
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
        int res = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            if (root == null) return 0;
            oneSideSum(root);
            return res;
        }

        private int oneSideSum(TreeNode root) {
            if (root == null) return 0;
            // 拿到左右子树的最大的值并且做比较， 这里要找正数，负数舍弃
            int leftMaxSum = Math.max(0, oneSideSum(root.left)); // 递归寻找左子树的最大路径和
            int rightMaxSum = Math.max(0, oneSideSum(root.right)); // 递归寻找右子树的最大路径和
            // 后序位置更新最大路径和
            int postMaxSum = root.val + leftMaxSum + rightMaxSum;
            res = Math.max(res, postMaxSum);
            // 实现函数定义，左右子树的最大单边路径和加上根节点的值
            // 就是从根节点 root 为起点的最大单边路径和
            return Math.max(leftMaxSum, rightMaxSum) + root.val;
        }
    }

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(7, null,null);
        TreeNode treeNode2 = new TreeNode(15, null, null);
        TreeNode treeNode4 = new TreeNode(9, null, null);
        TreeNode treeNode5 = new TreeNode(20, treeNode2, treeNode);
        TreeNode treeNode6 = new TreeNode(-10, treeNode5, treeNode4);
        System.out.println(new Solution().maxPathSum(treeNode6));
    }
}
