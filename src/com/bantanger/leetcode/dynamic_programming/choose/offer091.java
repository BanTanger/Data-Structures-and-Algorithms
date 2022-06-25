package com.bantanger.leetcode.dynamic_programming.choose;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/25 22:22
 */
public class offer091 {
    class Solution {
        public int minCost(int[][] costs) {
            // dp面对选择问题·
            int n = costs.length;
            int[][] dp = new int[n][3]; // 标记所选择的颜色
            dp[0][0] = costs[0][0];
            dp[0][1] = costs[0][1];
            dp[0][2] = costs[0][2];
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
            }
            int ans = Math.min(dp[n - 1][0], dp[n - 1][1]);
            return Math.min(ans, dp[n - 1][2]);
        }
    }
}
