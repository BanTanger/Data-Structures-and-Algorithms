package com.bantanger.leetcode.dynamic_programming.buy_and_sel_stocks;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/18 22:15
 */
public class LC_714_with_fee {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            if (prices.length == 0 || prices == null) return 0;
            int n = prices.length;
            int[][] dp = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[n - 1][0];
        }
    }
}
