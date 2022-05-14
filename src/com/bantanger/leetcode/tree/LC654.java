package com.bantanger.leetcode.tree;

import com.bantanger.leetcode.dynamic_programming.TreeNode;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/14 9:44
 */
public class LC654 {
    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return traverse(nums, 0, nums.length - 1);
        }
        private TreeNode traverse(int[] nums, int start, int end){
            if(start > end) return null;
            int index = findMaxIndex(nums, start, end);
            TreeNode node = new TreeNode(nums[index]);
            node.left = traverse(nums, start, index - 1);
            node.right = traverse(nums, index + 1, end);
            return node;
        }
        public int findMaxIndex(int[] nums, int left, int right){
            int max = Integer.MIN_VALUE;
            int maxIndex = left;
            for(int i = left; i <= right; i++) {
                if(max < nums[i]) {
                    max = nums[i];
                    maxIndex = i;
                }
            }
            return maxIndex;
        }
    }
}
