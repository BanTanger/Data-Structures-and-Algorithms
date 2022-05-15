package com.bantanger.leetcode.tree.bst;

import com.bantanger.leetcode.dynamic_programming.TreeNode;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/15 8:53
 */
public class LC98 {
    class Solution {
        // 很美的解法
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }
        // min --> 比 root 小
        // max --> 比 root 大
        private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
            if(root == null) return true;
            if(min != null && root.val <= min.val) return false;
            if(max != null && root.val >= max.val) return false;
            // 限定左子树的最大值是root.val, 右子树的最小值是root.val
            return isValidBST(root.left, min, root)
                    && isValidBST(root.right, root, max);
        }
    }
}
