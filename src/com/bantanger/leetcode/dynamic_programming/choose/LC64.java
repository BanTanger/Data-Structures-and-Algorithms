package com.bantanger.leetcode.dynamic_programming.choose;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/16 21:22
 */
public class LC64 {
    class Solution {
        public int minPathSum(int[][] grid) {
            // 路径问题之选择方向，可以用图论里的dfs，也可以用dp来解决
            // 观测数据量200上限，暗示着只能使用dp
            int n = grid.length, m = grid[0].length;
            // 定义dp[i][j],表示从(0,0)到(i,j)最小的数字和为dp[i][j]
            int[][] dp = new int[n][m];
            // 初始化
            dp[0][0] = grid[0][0];
            for (int i = 1; i < n; i++) dp[i][0] = dp[i - 1][0] + grid[i][0];
            for (int j = 1; j < m; j++) dp[0][j] = dp[0][j - 1] + grid[0][j];
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    // 这里涉及到的是选择问题。我们可以选择向左递推还是向上递推，选择的依据就是比较左上哪个更小
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                    // 注意下这里的选择，dp[i][j]的选取取决于上边左边哪个更小，再加上本身的路径数字
                    // System.out.println(dp[i][j]);
                }
            }
            return dp[n - 1][m - 1];
        }
    }
}
