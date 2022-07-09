package com.bantanger.leetcode.dynamic_programming.subarray;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/7/9 18:09
 */
public class LC392_twopointer {
    class Solution {
        public boolean isSubsequence(String s, String t) {
            int n = s.length(), m = t.length();
            s = " " + s;
            t = " " + t;
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (s.charAt(i) == t.charAt(j)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
            return dp[n][m] == n ? true : false;
        }
    }
}
