package com.bantanger.leetcode.dynamic_programming;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/4 9:54
 */
public class LC_343 {
    class Solution {
        public int integerBreak(int n) {
            // 定义dp为拆分整数最大乘积
            int[] dp = new int[n + 1];
            // dp初始化，0，1不能拆分，所以从dp[2]开始定义
            dp[2] = 1; // 2 = 1 + 1 ， 1 * 1 = 1；
            for (int i = 3; i <= n; i++) { // i 是 目前拆分的整数，最大到n，最小是3
                for (int j = 1; j <= i - j; j++) { // 一个整数的拆分过程
                    // 因为定义递推用的是j * (i - j)
                    // j 最大到i - j，就不会用到dp[0],dp[1]
                    // 并且此时(i - j) * (i - (i - j))满足公式
                    dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
                    // j * (i - j) 是单纯的把整数 i 拆分为两个数 也就是 i,i-j ，再相乘
                    //而j * dp[i - j]是将 i 拆分成两个以及两个以上的个数,再相乘。
                }
            }
            return dp[n];
        }
    }
}
