package com.bantanger.leetcode.Question_of_the_day.may.data_2022_05_13;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/6 17:27
 */
public class LC_01_05 {
    class Solution {
        /*使用编辑距离直接秒杀这道题，之前有点不太熟练，很多细节没处理好*/
        public boolean oneEditAway(String first, String second) {
            int n = first.length(), m = second.length();
            if (Math.abs(n - m) > 2) return false;
            int[][] dp = new int[n + 1][m + 1];
            dp[0][0] = 0;

            //当第一个字符串为""
            for (int i = 1; i <= n; i++) {
                dp[i][0] = i;
            }
            //当第二个字符串为""
            for (int j = 1; j <= m; j++) {
                dp[0][j] = j;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (first.charAt(i - 1) == second.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
            }
            if (dp[n][m] > 1) return false;
            return true;
        }
    }
}
