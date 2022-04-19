package com.bantanger.leetcode.dynamic_programming.subsequence;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/19 11:04
 */
public class LC_718_Repeat {
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            int result = 0;
            /**
             *  dp定义为`dp[i][j]`:表示以下标`i - 1`为结尾的数组**A**，和以下标`j - 1`为结尾的数组**B**，最长重复子数组长度为`dp[i][j]`。
             */
            int[][] dp = new int[n + 1][m + 1];
            // 初始化，因为递推需要dp[i - 1],i 从 1开始，所以会用到dp[0][j],dp[i][0]的情况。
            for (int i = 0; i < n; i++) dp[i][0] = 0;
            for (int j = 0; j < m; j++) dp[0][j] = 0;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (nums1[i - 1] == nums2[j - 1])
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
            return result;
        }
    }
}
