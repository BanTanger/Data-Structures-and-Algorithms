package com.bantanger.leetcode.tree.bst;

import com.bantanger.leetcode.dynamic_programming.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/6 17:30
 */
public class LC99 {
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
        // 创建两个临时变量记录两个要交换的节点
        TreeNode first = null, second = null;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);

        public void recoverTree(TreeNode root) {
            // 这题不能用验证BST的思路，因为验证和交换是不同的，验证只需要判断左右子树和根节点是否遵守BST的规则就行，但交换节点可能出现根节点和左右子树，也可能出现左右子树之间的交互
            helper(root);
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }

        private void helper(TreeNode root) {
            if (root == null) return;
            // 中序遍历，寻找逆序部分。如果只有一个逆序，就交换这个逆序对的值即可，但如果出现两个逆序对，就记录first为第一个逆序对的首，记录second为第二个逆序对的尾
            helper(root.left);
            if (root.val < prev.val) {
                if (first == null) {
                    first = prev; // 利用first == null 标记第一个逆序对的首节点
                    // first之后不在改变
                }
                second = root; // 如果只有一个逆序对，second记录的就是第二个要交换的节点，但如果有多个逆序对，就会一直更替到最后一个逆序对的末尾
            }
            prev = root;
            helper(root.right);
        }

        @Test
        public void test() {
            TreeNode treeNode = new TreeNode(1, null, null);
            TreeNode treeNode5 = new TreeNode(3, null, null);
            TreeNode treeNode6 = new TreeNode(2, treeNode, treeNode5);
            new Solution().recoverTree(treeNode6);
        }
    }
}
