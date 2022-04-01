package com.bantanger.leetcode.dynamic_programming;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/1 9:56
 */
public class LC_509 {
    class Solution {
        public int fib1(int n) {
            // 使用动态规划
            if (n == 0) return n;
            int[] dp = new int[n + 1];
            dp[0] = 0; dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }

        public int fib2(int n){
            // 动态规划，优化版：滚动数组
            if(n == 0 || n == 1) return n; // base case
            // 分别代表dp[i - 1] 和dp[i - 2]
            int dp_i_1 = 1,dp_i_2 = 0;
            for(int i = 2;i <= n; i++){
                // dp[i] = dp[i - 1] + dp[i - 2];
                int dp_i = dp_i_1 + dp_i_2;
                // 滚动更新
                dp_i_2 = dp_i_1;
                dp_i_1 = dp_i;
            }
            return dp_i_1;
        }
    }
}
