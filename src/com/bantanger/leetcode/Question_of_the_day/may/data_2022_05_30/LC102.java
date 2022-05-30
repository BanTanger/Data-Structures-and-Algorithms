package com.bantanger.leetcode.Question_of_the_day.may.data_2022_05_30;

import com.bantanger.leetcode.dynamic_programming.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/30 7:42
 */
public class LC102 {
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
        // 算法实现原理：
        // 因为树遍历的特性是从最高位往下遍历的，
        // 所以我们每遍历一个节点之后就把他往左挪，
        // 位运算就是 cnt <<= 1, 数学表示就是 cnt *= 2
        // 左挪腾出最后一位存放下一个节点
        // 表达式为 (cnt << 1) + root.val;
        public int sumRootToLeaf(TreeNode root) {
            return help(root, 0);
        }

        private int help(TreeNode root, int sum) {
            if (root == null) return 0;
            sum = 2 * sum + root.val;
            if (root.left == null && root.right == null) {
                return sum;
            }
            return help(root.left, sum) + help(root.right, sum);
        }
    }

    @Test
    public void test() {
        TreeNode node = new TreeNode(1, null, null);
        TreeNode node1 = new TreeNode(0, null, null);
        TreeNode node6 = new TreeNode(1, null, null);
        TreeNode node2 = new TreeNode(0, null, null);
        TreeNode node3 = new TreeNode(1, node1, node6);
        TreeNode node4 = new TreeNode(0, node2, node);
        TreeNode node5 = new TreeNode(1, node4, node3);
        new Solution().sumRootToLeaf(node5);
    }
}
