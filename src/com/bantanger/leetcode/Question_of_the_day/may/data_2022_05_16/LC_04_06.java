package com.bantanger.leetcode.Question_of_the_day.may.data_2022_05_16;

import com.bantanger.leetcode.dynamic_programming.TreeNode;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/6 17:27
 */
public class LC_04_06 {
    class Solution {
        // 定义方法为：从root开始，寻找p节点的后继节点
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if (root == null || p == null) return null;
            if (root.val <= p.val) {
                return inorderSuccessor(root.right, p);
                // 从root右子树开始，寻找比p大的后继节点
            }
            TreeNode ans = inorderSuccessor(root.left, p);
            return ans != null ? ans : root;
        }
    }
}
