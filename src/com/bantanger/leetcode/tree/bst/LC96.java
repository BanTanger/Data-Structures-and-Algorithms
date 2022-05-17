package com.bantanger.leetcode.tree.bst;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/16 18:18
 */
public class LC96 {
    class Solution {
        int[][] mome;
        public int numTrees(int n) {
            mome = new int[n + 1][n + 1];
            return count(1, n);
        }
        // 定义为[low, height] 的数字能组成 count(low, height) 中BST
        private int count(int low, int height) {
            if(low > height) return 1;
            // 如果查表发现当前递归的数据已经存在，就直接返回
            if(mome[low][height] != 0) return mome[low][height];
            int res = 0;
            // [lo, hi]闭区间，当前i作为BST的根节点
            for(int i = low; i <= height; i++) {
                int left = count(low, i - 1);
                int right = count(i + 1, height);
                res += left * right;
            }
            // 将结果存放在memo中
            mome[low][height] = res;
            return res;
        }
    }
}
