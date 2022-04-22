package com.bantanger.leetcode.dynamic_programming.subsequence;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/22 23:00
 */
public class LC_583_Delete {
    class Solution {
        public int minDistance(String word1, String word2) {
            int n = word1.length(), m = word2.length();
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
            return n + m - dp[n][m] * 2;
        }
    }
}
