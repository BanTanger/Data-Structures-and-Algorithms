package com.bantanger.leetcode.dynamic_programming.subsequence;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/20 9:55
 */
public class LC_1143_public {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int n = text1.length();
            int m = text2.length();
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (text2.charAt(j - 1) == text1.charAt(i - 1)) {
                        // 代表两指针遍历的位置元素相同，放入LCS中，长度增加
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        // 代表两个指针其中一个遍历的元素不在LCS中，
                        // （实际上有三种情况，都不在LCS的情况（长度最小）被前两种覆盖了，因为找的是最大值）
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[n][m];
        }
    }
}
