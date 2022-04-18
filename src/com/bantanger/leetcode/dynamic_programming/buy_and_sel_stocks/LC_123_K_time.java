package com.bantanger.leetcode.dynamic_programming.buy_and_sel_stocks;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/15 12:08
 */
public class LC_123_K_time {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) return 0;
            int n = prices.length;
            int[][] dp = new int[n][5];
            dp[0][1] = -prices[0];
            dp[0][3] = -prices[0];
            for (int i = 1; i < n; i++) {
                dp[i][0] = dp[i - 1][0]; // 不进行操作
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
                dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
                dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
            }
            return dp[n - 1][4];
        }
    }
}
