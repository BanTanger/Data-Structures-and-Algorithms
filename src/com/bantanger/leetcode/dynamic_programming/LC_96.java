package com.bantanger.leetcode.dynamic_programming;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/4 10:58
 */
public class LC_96 {
    class Solution {
        public int numTrees(int n) {
            // 定义dp[i] 为 i 个节点组成的所有二叉搜索树
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    // 递推公式：dp[i] += dp[j-1:以j为头结点左子树节点数量] * dp[i-j:为以j为头结点右子树节点数量]
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            return dp[n];
        }
    }
    @Test
    public void Test(){
        for(int i = 1;i <= 5; i++){
            for(int j = 1; j <= 5 - i; j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= i; j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
