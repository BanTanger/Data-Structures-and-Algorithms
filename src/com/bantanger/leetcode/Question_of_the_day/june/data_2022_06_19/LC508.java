package com.bantanger.leetcode.Question_of_the_day.june.data_2022_06_19;

import com.bantanger.leetcode.dynamic_programming.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/19 10:04
 */
public class LC508 {
    class Solution {
        int max = 0;

        public int[] findFrequentTreeSum(TreeNode root) {
            if (root == null) return new int[0];
            HashMap<Integer, Integer> map = new HashMap<>();
            helper(root, map);
            List<Integer> res = new ArrayList<>();
            for (Integer i : map.keySet()) {
                if (map.get(i) == max) res.add(i);
            }
            int[] resArr = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                resArr[i] = res.get(i);
            }
            return resArr;
        }

        // 函数定义为返回子树的和
        private int helper(TreeNode root, HashMap<Integer, Integer> map) {
            // base case
            // if(root.left == null && root.right == null) return root.val;
            // if(root.left == null) return root.right.val;
            // if(root.right == null) return root.left.val;
            if (root == null) return 0;
            int leftSum = helper(root.left, map);
            int rightSum = helper(root.right, map);
            int Sum = leftSum + rightSum + root.val;
            map.put(Sum, map.getOrDefault(Sum, 0) + 1);
            max = Math.max(max, map.get(Sum));
            return Sum;
        }
    }
}
