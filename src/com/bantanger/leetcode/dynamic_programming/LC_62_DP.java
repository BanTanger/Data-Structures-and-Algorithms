package com.bantanger.leetcode.dynamic_programming;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/3 8:44
 */
public class LC_62_DP {
    /**
     * 1. 确定dp数组下标含义 dp[i][j] 到每一个坐标可能的路径种类
     * 2. 递推公式 dp[i][j] = dp[i-1][j] dp[i][j-1]
     * 3. 初始化 dp[i][0]=1 dp[0][i]=1 初始化横竖就可
     * 4. 遍历顺序 一行一行遍历
     * 5. 推导结果 。。。。。。。。
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        // 1. 定义dp数组
        int[][] dp = new int[m][n];
        // 2. 初始化
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        // 4. 确定遍历方向
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 3. 确定递推公式
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
