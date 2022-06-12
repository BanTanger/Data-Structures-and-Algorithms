package com.bantanger.leetcode.dynamic_programming;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/11 22:10
 */
public class offer47 {
    class Solution {
        public int maxValue(int[][] grid) {
            int n = grid.length, m = grid[0].length;
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }
            return dp[n][m];
        }
    }

    @Test
    public void test() {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(new Solution().maxValue(grid));
    }
}
