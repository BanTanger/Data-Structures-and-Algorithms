package com.bantanger.leetcode.dynamic_programming;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/16 8:38
 */
public class LC_309 {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) return 0;
            int n = prices.length;
            int[][] dp = new int[n][4];
            // 状态一：持有股票
            // 状态二：之前就卖出股票
            // 状态三：今天就卖出股票
            // 状态四：冻结期
            dp[0][0] = -prices[0]; // 在第一天持有股票，现金减少股票价格
            dp[0][1] = 0; // 第一天卖出股票，相当于没赚钱
            dp[0][2] = 0; // 同理状态二，只是状态二极端了点
            dp[0][3] = 0; // 冻结期收益0元

            for (int i = 1; i < n; i++) {
                // 持有股票有三种可能：前一天就保持持有股票的状态，二是前一天保持卖出股票状态，（这里要选状态二），三是前一天为冻结期
                dp[i][0] = Math.max(dp[i - 1][0],
                        Math.max(dp[i - 1][1], dp[i - 1][3]) - prices[i]);
                // 之前就卖出股票有两种可能：保持之前卖出股票的状态，二是当前为冻结期。
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
                // 今天卖出股票只有一种可能，即出手卖出，金额增加
                dp[i][2] = dp[i - 1][0] + prices[i];
                // 冻结期只会出现在状态三卖出票后
                dp[i][3] = dp[i - 1][2];
            }
            // 最后结果是取 状态二，状态三，和状态四的最大值，状态四是冷冻期，最后一天如果是冷冻期也可能是最大值
            return Math.max(dp[n - 1][3], Math.max(dp[n - 1][1], dp[n - 1][2]));
        }
    }
}
