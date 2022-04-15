package com.bantanger.leetcode.dynamic_programming;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/15 8:08
 */
public class LC_121_dp {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) return 0;
            int n = prices.length;
            int[][] dp = new int[n][2];
            // 0代表持有股票，1代表不持有
            dp[0][0] = -prices[0];
            dp[0][1] = 0;
            // 因为对下标0进行初始化了，所以直接从下标一开始遍历，贪心就需要从0开始遍历了，需要搞清楚
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            }
            return dp[n - 1][1];
        }
    }
}
