package com.bantanger.leetcode.dynamic_programming;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/15 8:26
 */
public class LC_122_dp {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0 || prices == null) return 0;
            int n = prices.length;
            int[][] dp = new int[n][2];
            dp[0][0] = -prices[0];
            dp[0][1] = 0;
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            }
            return dp[n - 1][1];
        }
    }
}
