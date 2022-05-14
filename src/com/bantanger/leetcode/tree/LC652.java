package com.bantanger.leetcode.tree;

import com.bantanger.leetcode.dynamic_programming.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/14 15:11
 */
public class LC652 {
    class Solution {
        HashMap<String, Integer> map = new HashMap<>();
        LinkedList<TreeNode> res = new LinkedList<>();
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            if(root == null) return null;
            helper(root);
            return res;
        }
        private String helper(TreeNode root) {
            if(root == null) return "#";
            String left = helper(root.left);
            String right = helper(root.right);

            String subTree = left + "," + right + "," + root.val;
            int freq = map.getOrDefault(subTree, 0);
            if(freq == 1) res.add(root);
            map.put(subTree, freq + 1);
            return subTree;
        }
    }
}
