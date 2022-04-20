package com.bantanger.leetcode.dynamic_programming.subsequence;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/20 11:33
 */
public class LC_1035 {
    class Solution {
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            // 最长公共子序列换汤不换药
            int n = nums1.length;
            int m = nums2.length;
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[n][m];
        }
    }
}
