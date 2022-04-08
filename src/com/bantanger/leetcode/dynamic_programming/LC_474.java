package com.bantanger.leetcode.dynamic_programming;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/8 10:01
 */
public class LC_474 {
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int[][] dp = new int[m + 1][n + 1];
            int oneNum = 0, zeroNum = 0;
            for (String str : strs) {
                oneNum = 0;
                zeroNum = 0;
                for (char ch : str.toCharArray()) {
                    if (ch == '0') zeroNum++;
                    if (ch == '1') oneNum++;
                }
                // 01背包倒序遍历
                for (int i = m; i >= zeroNum; i--) {
                    for (int j = n; j >= oneNum; j--) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                    }
                }
            }
            return dp[m][n];
        }
    }
}
