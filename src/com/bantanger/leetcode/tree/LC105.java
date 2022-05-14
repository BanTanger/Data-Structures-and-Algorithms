package com.bantanger.leetcode.tree;

import com.bantanger.leetcode.dynamic_programming.TreeNode;

import java.util.HashMap;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/14 10:46
 */
public class LC105 {
    class Solution {
        // 使用hashmap对inorder里的数据进行映射，避免使用for造成耗时过大
        HashMap<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length, m = inorder.length;
            for (int i = 0; i < m; i++) {
                map.put(inorder[i], i);
            }
            return helper(preorder, 0, n - 1, inorder, 0, m - 1);
        }

        private TreeNode helper(int[] preorder, int preLeft, int preRight,
                                int[] inorder, int inLeft, int inRight) {
            if (preLeft > preRight) return null; // base case
            int rootVal = preorder[preLeft];
            // 查看rootVal在中序遍历数组中的下标索引
            int index = map.get(rootVal);
            // 得到划分区间中序数组的左子树个数长度
            int leftSize = index - inLeft;
            // 构造出当前根节点
            TreeNode root = new TreeNode(rootVal);
            root.left = helper(preorder, preLeft + 1, preLeft + leftSize, inorder, inLeft, index - 1);
            root.right = helper(preorder, preLeft + leftSize + 1, preRight, inorder, index + 1, inRight);
            return root;
        }
    }
}
