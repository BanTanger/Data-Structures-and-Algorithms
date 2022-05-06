package com.bantanger.leetcode.tree;

import com.bantanger.leetcode.dynamic_programming.TreeNode;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/6 20:03
 */
public class LC543_MaxDiameter {
    // 记录最大直径的长度
    private int maxDiameter = 0;

    class PreRecur_Solution {
        public int diameterOfBinaryTree(TreeNode root) {
            // 对每个节点计算直径，求最大直径
            traverse(root);
            return maxDiameter;
        }

        // 遍历二叉树
        void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            // 对每个节点计算直径
            int leftMax = maxDepth(root.left);
            int rightMax = maxDepth(root.right);
            int myDiameter = leftMax + rightMax;
            // 更新全局最大直径
            maxDiameter = Math.max(maxDiameter, myDiameter);

            traverse(root.left);
            traverse(root.right);
        }

        // 计算二叉树的最大深度
        int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftMax = maxDepth(root.left);
            int rightMax = maxDepth(root.right);
            return 1 + Math.max(leftMax, rightMax);
        }
    }

    class BeRecur_Solution {

    }
}
