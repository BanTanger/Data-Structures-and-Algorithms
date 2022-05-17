package com.bantanger.leetcode.tree.bst;

import com.bantanger.leetcode.dynamic_programming.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/16 20:53
 */
public class LC95 {
    class Solution {
        public List<TreeNode> generateTrees(int n) {
            if(n == 0) return new LinkedList<>();
            return helper(1, n);
        }
        private List<TreeNode> helper(int lo, int hi) {
            List<TreeNode> res = new LinkedList<>();
            if(lo > hi) {
                res.add(null);
                return res;
            }
            // 闭区间 需要i <= hi
            // [lo, hi]闭区间，当前i作为BST的根节点
            for(int i = lo; i <= hi; i++) {
                List<TreeNode> leftTree = helper(lo, i - 1);
                List<TreeNode> rightTree = helper(i + 1, hi);
                for(TreeNode left : leftTree) {
                    for (TreeNode right : rightTree) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        res.add(root);
                    }
                }
            }
            return res;
        }
    }
    @Test
    public void test(){
        Solution solution = new Solution();
        solution.generateTrees(4);
    }
}
