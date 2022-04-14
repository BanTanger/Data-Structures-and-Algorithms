package com.bantanger.leetcode.dynamic_programming;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/12 10:50
 */

public class LC_337_backtrack_and_memoized_search {
    class TreeNode {
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
            memoized search
         */
        HashMap<TreeNode, Integer> map = new HashMap<>();

        public int rob(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null && root.right == null) return root.val;
            if (map.containsKey(root)) return map.get(root); // 查备忘录
            // 选择偷父节点,情况A
            int val_A = root.val;
            if (root.left != null) val_A += rob(root.left.left) + rob(root.left.right); // 跳跃当前左子树去获取子树的子树
            if (root.right != null) val_A += rob(root.right.left) + rob(root.right.right); // 跳跃当前右子树去获得子树的子树

            // 选择不偷父节点,情况B
            int val_B = rob(root.left) + rob(root.right);
            map.put(root, Math.max(val_A, val_B)); // 将比较结果放在备忘录中
            return Math.max(val_A, val_B);
        }
    }

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, null, null), null);
        int rob = new Solution().rob(treeNode);
        System.out.println(rob);
    }
}
