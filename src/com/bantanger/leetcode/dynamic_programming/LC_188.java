package com.bantanger.leetcode.dynamic_programming;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/16 8:09
 */
public class LC_188 {
    class Solution {
        public int maxProfit(int k, int[] prices) {
            if (prices == null || prices.length == 0) return 0;
            int[][] dp = new int[prices.length][2 * k + 1];
            for (int j = 1; j < 2 * k; j += 2) {
                dp[0][j] = -prices[0]; // 初始化
            }
            for (int i = 1; i < prices.length; i++) {
                for (int j = 0; j < 2 * k - 1; j += 2) {
                    dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                    dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
                }
            }
            return dp[prices.length - 1][2 * k];
        }
    }
}
