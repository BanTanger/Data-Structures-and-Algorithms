package com.bantanger.leetcode.tree;

import com.bantanger.leetcode.dynamic_programming.TreeNode;

import java.util.HashMap;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/14 10:59
 */
public class LC106 {
    class Solution {
        HashMap<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int n = inorder.length, m = postorder.length;
            for (int i = 0; i < n; i++) {
                map.put(inorder[i], i);
            }
            return helper(inorder, 0, n - 1, postorder, 0, m - 1);
        }

        private TreeNode helper(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
            if (postLeft > postRight) return null;
            int rootVal = postorder[postRight];
            int index = map.get(rootVal);
            int rightSize = inRight - index;

            TreeNode root = new TreeNode(rootVal);
            root.left = helper(inorder, inLeft, index - 1, postorder, postLeft, postRight - 1 - rightSize);
            root.right = helper(inorder, index + 1, inRight, postorder, postRight - rightSize, postRight - 1);
            return root;
        }
    }
}
