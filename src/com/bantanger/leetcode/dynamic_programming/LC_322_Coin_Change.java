package com.bantanger.leetcode.dynamic_programming;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/9 11:29
 */
public class LC_322_Coin_Change {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            // 完全背包解法
            int max = Integer.MAX_VALUE; // 要求最小值，一开始定义成系统最大，防止一直被零覆盖
            // 定义dp[j]代表最小硬币个数,凑出金额为j的钱币最少数量为dp[j]个
            int[] dp = new int[amount + 1];
            for (int j = 0; j < dp.length; j++) {
                dp[j] = max;
            }
            dp[0] = 0; //凑出金额为0的钱币个数为0
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    // 只有dp[j - coins[i]] 不是初始最大值是，该位才有选择的必要
                    if (i - coins[j] >= 0 && dp[i - coins[j]] != max)
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
            // 不能找零校验
            return dp[amount] == max ? -1 : dp[amount];
        }
    }
}
