package com.bantanger.leetcode.Question_of_the_day.june.data_2022_06_11;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/11 21:04
 */
public class LC926 {
    class Solution {
        public int minFlipsMonoIncr(String s) {
            // dp[i][0] 表示第 i 位为 0,dp[i][1] 表示第 i 位为 1
            int n = s.length();
            int[][] dp = new int[n + 1][2];
            for (int i = 1; i <= n; i++) {
                if (s.charAt(i - 1) == '0') { // 当前元素为0时
                    dp[i][0] = dp[i - 1][0];
                    dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
                } else { // 当前元素元素为1时
                    dp[i][0] = dp[i - 1][0] + 1;
                    dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                }
            }
            return Math.min(dp[n][1], dp[n][0]);
        }
    }
}
