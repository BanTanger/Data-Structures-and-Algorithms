package com.bantanger.leetcode.dynamic_programming.choose;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/16 21:46
 */
public class LC313 {
    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            // 多指针 + 动态规划
            int m = primes.length;
            int[] temp = new int[m]; // 开辟一个质因数等大的数组，存放多指针
            int[] dp = new int[n]; // 创建n个dp
            dp[0] = 1;
            for (int i = 1; i < n; i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 0; j < m; j++) { // 选取当前最小的dp
                    dp[i] = Math.min(dp[temp[j]] * primes[j], dp[i]);
                }
                for (int k = 0; k < m; k++) { // 遍历每一个指针，如果符合就让该指针进一
                    if (dp[i] % primes[k] == 0) temp[k]++;
                }
            }
            return dp[n - 1];
        }
    }
}
