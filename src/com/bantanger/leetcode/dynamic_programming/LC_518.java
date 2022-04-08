package com.bantanger.leetcode.dynamic_programming;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/8 10:39
 */
public class LC_518 {
    class Solution {
        public int change(int amount, int[] coins) {
            //递推表达式
            int[] dp = new int[amount + 1];
            //初始化dp数组，表示金额为0时只有一种情况，也就是什么都不装
            dp[0] = 1;
            for (int i = 0; i < coins.length; i++) {
                for (int j = coins[i]; j <= amount; j++) {
                    dp[j] += dp[j - coins[i]];
                }
            }
            return dp[amount];
        }
    }

    public static void main(String[] args) {

    }
}
